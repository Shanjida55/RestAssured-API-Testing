#### Project Description:
This project is a demonstration of API automation using Rest Assured in Java, focusing on the RestfulBooker API. RestfulBooker provides endpoints for performing various HTTP methods such as POST, GET, PUT, PATCH, and DELETE to manage bookings.

#### Features:
##### Booking Creation:
The project showcases the ability to create bookings using the POST method. Upon creation, a unique ID is generated for each booking.
##### Booking Information Retrieval: 
Users can retrieve booking information by providing the booking ID obtained during creation. This allows for easy access to specific booking details.
##### Token Generation: 
The project demonstrates token generation, a crucial aspect of API authentication. Tokens are required for certain privileged actions such as modifying or deleting bookings.
##### Booking Modification:
Using the generated token and booking ID, the project enables PUT and PATCH requests to update booking details as needed.
##### Booking Deletion: 
Finally, the project supports the deletion of bookings using the DELETE method, ensuring flexibility in managing booking data.
