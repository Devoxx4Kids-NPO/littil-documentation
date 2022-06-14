# Auth0 integration

## Integration
LiTTiL currently uses Auth0 as a Single Sign On solution. Auth0 can take a lot of work off our hands when you use all the
utilities Auth0 has to offer. For example completely host the registration and login procedure within Auth0 itself. 
This makes it very easy and fast to implement, it has it's benefits. But for LiTTiL we would like to persist the user 
in our own database as well. 

For example, when we have a user entity within the platform, it is easier to create a link between this user and settings. 
The loose coupling with Auth0 should also benefit the implementation or new features but also makes sure we can always 
move to another Single Sign On solution when necessary. 

## User entity within LiTTiL
![User object mapping](../../../diagrams/out/user-model-mapping.svg)

## Registration flow
Below you can find the sequence diagram of the registration flow. When registering the user already makes an account as 
either a school or teacher. For each of this type the `RegistrationResouce` should have an endpoint. For example: 
`/api/v1/registrate/(school|teacher)`. This determines the accountType. At this moment the user is _unable_ to change the 
type of an account. 

![Registration sequence diagram](../../../diagrams/out/registration-process-sequence-diagram.svg)