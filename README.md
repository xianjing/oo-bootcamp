oo-BootCamp
===========

### Requirement V ParkingManager

Given a parkingManager manages 1 parkingBoy and 1 parkingLots
And the parkingBoy has 1 parkingLots with available slots
When park a car
Should succeed


### Requirement IV Super ParkingBoy

Given a parkingBoy having 2 parkingLots,
And the first parkingLot's vacancy rate is greater than the second,
When park a car
Should succeed and park into the first parkingLots


### Requirement III Smart ParkingBoy

Given a parkingBoy having 2 parkingLots,
And the first parkingLot's available slots is greater than the second.
When park a car
Should succeed and park into the first parkingLots



### Requirement II - ParkingBoy

Given a ParkingBoy having 2 parkingLots that have available slots
When park a car
Should succeed

Given a ParkingBoy having 2 parkingLots and both are full
When park a car
Should fail

Given a ParkingBoy having 2 parkingLots that have one car parked
When unpark with valid ticket
Should succeed

Given a ParkingBoy having 2 parkingLots
When unpark with invalid ticket
Should fail

### Requirement I - Park/Unpark

Given a parkingLots have available slots
When park a car
Should succeed

Given a parkingLots is full
When park a car
Should fail

Given a parkingLots have one car parked
When get car with valid ticket
Should succeed

Given a parkingLots have one car parked
When get car with invalid ticket
Should fail
