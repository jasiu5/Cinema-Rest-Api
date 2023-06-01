#!/bin/bash
description[1]='All screenings: '
command[1]='curl -X GET localhost:8080/screenings/all'
description[2]='All screenings by date and time: '
command[2]='curl -X GET localhost:8080/screenings?date=2023-06-10&time=12:45:00'
description[3]='All seats by screening: '
command[3]='curl -X GET localhost:8080/screenings/seats?screeningId=3'
description[4]='Reserve screening : '
command[4]="curl -H Content-Type:application/json -X POST -d {\"name\":\"Jan\",\"surname\":\"Łachowski-Kowalski\",\"ticketType\":\"student\",\"screeningId\":3,\"seatId\":118} localhost:8080/screenings/reservation"
description[5]='Reserve screening at same place: '
command[5]="curl -H Content-Type:application/json -X POST -d {\"name\":\"Jan\",\"surname\":\"Lachowski\",\"ticketType\":\"student\",\"screeningId\":3,\"seatId\":118} localhost:8080/screenings/reservation"
description[6]='Reserve screening with short name: '
command[6]="curl -H Content-Type:application/json -X POST -d {\"name\":\"J\",\"surname\":\"Lachowski\",\"ticketType\":\"student\",\"screeningId\":3,\"seatId\":119} localhost:8080/screenings/reservation"
description[7]='Reserve screening with one seat left between: '
command[7]="curl -H Content-Type:application/json -X POST -d {\"name\":\"Jan\",\"surname\":\"Lachowski\",\"ticketType\":\"student\",\"screeningId\":3,\"seatId\":120} localhost:8080/screenings/reservation"

for i in {1..7}
do
	echo ${description[$i]}
	printf '\n'
	echo ${command[$i]}
	printf '\n'
	${command[$i]}
	printf '\n'
	read -n 1 -s -r -p "Press any key to continue to next endpoint"
	printf '\n'
done