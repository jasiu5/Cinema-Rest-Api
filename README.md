# Cinema REST Api
# How to run
The script buil.sh creates docker container and run application there.	

To run write down in cmd: "sh build.sh"

And to test: "sh test.sh"

The test scenario tests all use cases described below:

1. The user selects the day and the time when he/she would like to see the movie.
2. The system lists movies available in the given time interval - title and screening
times.
3. The user chooses a particular screening.
4. The system gives information regarding screening room and available seats.
5. The user chooses seats, and gives the name of the person doing the reservation
(name and surname).
6. The system gives back the total amount to pay and reservation expiration time.
