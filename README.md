# Supermarket

Demo of Supermarket with simple checkout mechanism created and designed by Shivam Oberoi.

### Business requirements:

Design and implement supermarket checkout component with readable API that calculates the total unit of a number of items. Checkout mechanism can scan items and return actual unit ( is stateful) Our goods are priced individually. In addition, some items are multipriced: buy n of them, and they’ll cost you y cents 

|Item  | Unit Price |  Special Price |
  |:----:|-----------:|---------------:|
  |  A   |  40        | 3 for 70       |
  |  B   |  10        | 2 for 15       | 
  |  C   |  30        |                |
  |  D   |  25        |                |



### To Start

Clone the repo: git clone https://github.com/shivam-oberoi/Supermarket.git Fork the repo Prerequisites
This is a spring boot application. Run mvn clean install in the root directory 

*To run:  `mvn spring-boot:run`



### Architecture Design:

MVC(Model, view and Controller)
1.	Controller:- For all incoming request.
2.	Mapper for DTO TO DO and DO to DTO.
3.	Service:-Business Logic to handle all the processing.
4.	DAO:-All for the database operation(save, delete).

### API:

1.	Create New Order:- 

curl -X POST --header "Content-Type: application/json" --header "Accept: */*" "http://localhost:8080/v1/order/newOrder""

2.	Scan product:- 

*curl -X POST --header "Content-Type: application/json" --header "Accept: /" -d "{ "productid": 1, "quantity": 4 }" "http://localhost:8080/v1/checkout/1"

3.	Get all orderlines(cartdetails) for an order:- 

*curl -X GET --header "Accept: /" "http://localhost:8080/v1/order/orderLines/1"

