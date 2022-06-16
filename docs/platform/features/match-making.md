# Matching teacher to schools

## Additional address properties
For our match making we need the `longitude` and `latitude` coordinates which correspond with the location of either
the school or teacher. These coordinates needs to be fetched when the user has registered but also when the location
of the specific user changes. Google has an API available to find the coordinates based on addresses. The flow below 
described how we asynchronously fetch these coordinates using this API.

![Fetching coordinates from Google](../../diagrams/out/fetch-address-coordinates.svg)