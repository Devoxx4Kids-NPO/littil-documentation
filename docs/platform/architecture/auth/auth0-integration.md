# Auth0 integration

## Integration
LiTTiL currently uses Auth0 as a Single Sign On solution. Auth0 can take a lot of work off our hands when you use all the
utilities Auth0 has to offer. For example completely host the registration and login procedure within Auth0 itself. 
This makes it very easy and fast to implement, it has it's benefits. But for LiTTiL we would like a LiTTiL more control
over the login and registration flows, and thus loose coupling with Auth0. We can add more custom check when registration 
but also move to another SSO provider without needing to rewrite the whole registration / login flows. 

## User entity within LiTTiL
![User object mapping](../../../diagrams/out/user-model-mapping.svg)

## Registration flow
Below you can find the sequence diagram of the registration flow. When registering either a school or teacher entity is created. 
This entity is added to the user object which is created and stored in Auth0. For both account types the `RegistrationResouce` 
should have an endpoint. For example: `/api/v1/registrate/(school|teacher)`. At this moment the user is _unable_ to change the 
type of an account. 

![Registration sequence diagram](../../../diagrams/out/registration-process-sequence-diagram.svg)

## Custom token claims
To provide our tokens with useful information of the authorizations of the user. From within the littil-backend we feed the metadata of the user with this information. Using an `custom-action` on the login-flow we convert the metadata to custom-claims.

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
