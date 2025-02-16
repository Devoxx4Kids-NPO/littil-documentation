# Auth0 integration

## Integration

LiTTiL currently uses Auth0 as a Single Sign On solution. Auth0 can take a lot of work off our hands when you use all
the
utilities Auth0 has to offer. For example completely host the registration and login procedure within Auth0 itself.
This makes it very easy and fast to implement, it has it's benefits. But for LiTTiL we would like a LiTTiL more control
over the login and registration flows, and thus loose coupling with Auth0. We can add more custom check when
registration
but also move to another SSO provider without needing to rewrite the whole registration / login flows.

## User entity within LiTTiL

![User object mapping](../../../diagrams/out/user-model-mapping.svg)

## Registration flow

Below you can find the sequence diagram of the registration flow. When registering either a school or teacher entity is
created.
This entity is added to the user object which is created and stored in Auth0. For both account types
the `RegistrationResouce`
should have an endpoint. For example: `/api/v1/registrate/(school|teacher)`. At this moment the user is _unable_ to
change the
type of an account.

![Registration sequence diagram](../../../diagrams/out/registration-process-sequence-diagram.svg)

### Create account option disabled

A user is created by the backend of the LITTIL platform.
The option to prevent users creating an account directly in auth0 is disabled.
The option `Disable Sign Ups` is activated in the menu `Authentication - Database`.

## Clients

We have multiple clients registered in Auth0 for different reasons. Each of them described below with their important
config.

### littil

A `single page application` client, which is used by the littil-frontend. Users will be forced to login when using the
frontend using this client.

Important configs for this client are:

- Allowed callback urls
    - dev: `http://localhost:4200, http://localhost:4200/*`
    - staging: `https://staging.littil.org, https://staging.littil.org/*, https://api.staging.littil.org, https://api.staging.littil.org/*`
- Allowed logout urls
    - dev: `http://localhost:4200, http://localhost:4200/*`
    - staging: `https://staging.littil.org, https://staging.littil.org/*, https://api.staging.littil.org, https://api.staging.littil.org/*`
- Allowed web origins
    - dev: `http://localhost`
    - staging: `https://staging.littil.org, https://api.staging.littil.org`
- Grant types should be
    - Implicit
    - Authorization code
    - Refresh token
- Connections
    - Username-Password-Authentication

All other settings are default.

## LiTTiL backend

A `Machine to machine` client, used by the littil-backend. The littil-backend uses this client to manage the users,
roles and user-metadata in Auth0.

Important configs for this client are:

- Grant types should be
    - Client credentials
    - Refresh token
- APIs
    - Auth0 Management API should be enabled, with the following permissions:
        - read:users
        - update:users
        - create:users
        - delete:users
        - read:users_app_metadata
        - update:users_app_metadata
        - create:users_app_metadata
        - delete:users_app_metadata
        - read:roles
        - update:roles
        - create:roles
        - delete:roles

All other settings are default.

### LiTTiL backend OpenAPI

A `single page application` client, which is used by the littil-backend. Developers will use this client when testing
their APIs using the swagger client. Currently, this client will only be available in development environment.

Important configs for this client are:

- Allowed callback urls
    - dev: `http://localhost:8080/*, http://localhost:8080/q/swagger-ui/, http://localhost:8080/q/swagger-ui/oauth2-redirect.html, http://localhost:8080/q/swagger-ui/*`
- Allowed logout urls
    - dev: `http://localhost:8080, http://localhost:8080/q/swagger-ui/`
- Grant types should be
    - Implicit
    - Authorization code
    - Refresh token
- Connections
    - Username-Password-Authentication

All other settings are default.

## Custom token claims

To provide our tokens with useful information of the authorizations of the user. From within the littil-backend we feed
the metadata of the user with this information. Using an `custom-action` on the login-flow we convert the metadata to
custom-claims.

The custom-action can be found below `Actions > library > Custom actions`

We use the following code:

``` javascript
exports.onExecutePostLogin = async (event, api) => {
  const namespace = '';
  const { littil_user_id, authorizations } = event.user.app_metadata;

  if(event.authorization) {
    api.accessToken.setCustomClaim(`${namespace}littil_user_id`, littil_user_id);
    api.accessToken.setCustomClaim(`${namespace}authorizations`, authorizations);
  }
};
```

After creating the custom-action, make sure to drag the custom-action into the login flow.
