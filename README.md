Approach:
1. Build a docker container with the database also running in the container
2. Add a docker compose file that lists both database and the app

Compile and Running:
1. Run the following to compile
gradlew build

2. Build and start the docker container
docker-composer up --build

Progress:
1. Able to obtain top 20 movies across the last 5 years
2. Able to get movie details for each of the movie