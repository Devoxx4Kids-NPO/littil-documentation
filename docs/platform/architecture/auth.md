#Authentication and authorization WORK IN PROGRESS

## Role and permissions tables

The following table lists the available roles that can be assigned to registered users of the platform

| User | Description |
| ----------- | ----------- |
|teacher|assigned to a registered user who uses the platform as a volunteer teacher |
|school|assigned to the user who is the designated point of contact for a school |
|admin|assigned to a user with complete administrative control. |

## Permissions explained

Authorized users of the platform invoke the REST api to read and write resources from/to the data store.

For non-admin users, not all data records in a single resources (school or teacher) can be accessed/edited with the same permissions. 
Typically, such a user can only see the records that are relevant to their account. For a teacher this would be their own account and the school they are associated with, and likewise for the school. 

### Read permissions for teacher resources

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
| list teachers by any search criteria | admin | a search can be unrestricted search and hence return the complete list of teachers|
| look up a random teacher by their id | admin |
| a teacher looks up their own record | teacher|
| a school contact looks up a teacher of their school | teacher| the teacher has to be explicitly connected to the same school |

### Read permissions for school resources

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
| list schools by any search criteria | admin | a search can be unrestricted search and hence return the complete list of schools.|
| look up a random school by its id | admin |
| a school contact looks up their school record | school | 
| a teacher looks up the school that they are connected with | teacher |


### Write permissions for teacher resource

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
|update the teacher record of the logged-in user|teacher||
|delete the teacher record of the logged-in user|teacher||
|update a teacher record for a random user|admin||
|delete a teacher record for a random user|admin||

### Write permissions for school resource

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
|update the school record of the logged-in user|teacher||
|delete the school record of the logged-in user|teacher||
|update a school record for a random user|admin||
|delete a school record for a random user|admin||
