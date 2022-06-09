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
Typically, such a user can only edit their own record but read all other records. For a teachter this would be their own record they can edit. A teacher can also see all other teachers but not all details from them (only names, city and meterials they teach. This way a teacher can find another teacher to work on new materials.
A school can find all schools registered but only see the basic details like the name of the school and the city. This is also for the school when they search for a teacher. They can find all teachers in the system but only the name, city and materials they teach.
No contact details will be shown. This is only visible for the admin. If a school wants to come in contact with a teacher they can select the teacher, write a message and send it using the LITTIL platform. The LITTIL platform will mail the teacher the message and the contactdetails of the school.

### Read permissions for teacher resources

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
| list teachers by any search criteria | admin | a search can be unrestricted search and hence return the complete list of teachers|
| look up a random teacher by their id | admin |
| a teacher looks up their own record | teacher|
| a school can looks up any teacher with basic details | school |  |

### Read permissions for school resources

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
| list schools by any search criteria | admin | a search can be unrestricted search and hence return the complete list of schools.|
| look up a random school by its id | admin |
| a school contact looks up their school record | school | 
| a school can look up all other schools with basic details | school |
| a teacher can looks up the school that they are connected with full details | teacher |
| a teacher can look up any school with basic details |


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
