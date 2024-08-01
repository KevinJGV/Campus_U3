"use strict";

const DISCOVER_URL = new URL(
    "https://api.themoviedb.org/3/discover/movie?include_adult=true&include_video=true&language=es-MX&page=1&sort_by=popularity.desc"
);

const HEADER = {
    accept: "aplication/json",
    Authorization: "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYTI2MzY4MTY4YTM2NzY1ODdmNTg4NTYzYmFlOWI4NyIsIm5iZiI6MTcyMjQ3NDgxMS41MDE1OTQsInN1YiI6IjY2YWE5MmE1NDIzMjEyYzBhMjc1NmZlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ntBofgPwwTBzWPWESmj7usOS8LSrsXu7Q64vFOQqv-c"  
};

const OPTIONS = {
    method: "GET",
    headers: HEADER
}

const REQUEST = new Request(DISCOVER_URL, OPTIONS);


fetch(REQUEST)
    .then((response) => {
        response.json()})
    .then((response) => console.log(response))
    .catch((err) => console.error(err));
