"use strict";

localStorage.setItem("current_page", 1);

function getLocalSt(key,conversion) {
    if (conversion === undefined) {
        return localStorage.getItem(key);
    } else if (conversion === Number) {
        return Number(localStorage.getItem(key));
    }
}

function making_cards(movie) {
    let [card, h1, img, date_p, score_p] = structure_cards();
    h1.textContent = movie.title;
    const capturadorErrorImg = () => img.src = "https://http.cat/images/400.jpg";
    img.onerror = capturadorErrorImg
    img.src = `https://image.tmdb.org/t/p/w500/${movie.poster_path}`;
    if (movie.release_date !== "") {
        date_p.textContent = movie.release_date;
    } else {
        date_p.textContent = "Undefined"
    }
    
    const DATE_STRONG = document.createElement("strong");
    DATE_STRONG.textContent = "Release: ";
    date_p.insertAdjacentElement("afterbegin", DATE_STRONG);
    score_p.textContent = movie.popularity;
    const SCORE_STRONG = document.createElement("strong");
    SCORE_STRONG.textContent = "Popularity: ";
    score_p.insertAdjacentElement("afterbegin", SCORE_STRONG);
    [h1, img, date_p, score_p].forEach((elem) =>
        card.insertAdjacentElement("beforeend", elem)
    );
    return card;
}

function structure_cards() {
    const CARD = document.createElement("div");
    CARD.classList.add("card", "flex_col", "j-sb", "text_center");
    const TITLE = document.createElement("h3");
    const IMG = document.createElement("img");
    IMG.classList.add("j-all_c");
    const DATE = document.createElement("p");
    const SCORE = document.createElement("p");
    return [CARD, TITLE, IMG, DATE, SCORE];
}

async function cargarPagina() {
    const JSON = await gettingJson();
    const CURRENT = document.querySelector(".current_pag");
    CURRENT.textContent = JSON.page;
    const TOTAL = document.querySelector(".total_pags");
    TOTAL.textContent = JSON.total_pages;
    JSON.results.forEach((movie) => {
        const CARD = making_cards(movie);
        SECTION.insertAdjacentElement("beforeend", CARD);
    });
    return JSON
}

async function gettingJson() {
    const DISCOVER_URL = new URL(
        `https://api.themoviedb.org/3/discover/movie?include_adult=true&include_video=true&language=es-MX&page=${getLocalSt("current_page")}&sort_by=title.asc`);
    
    const HEADER = {
        accept: "aplication/json",
        Authorization:
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYTI2MzY4MTY4YTM2NzY1ODdmNTg4NTYzYmFlOWI4NyIsIm5iZiI6MTcyMjQ4NTQ5MC40MjE3ODksInN1YiI6IjY2YWE5MmE1NDIzMjEyYzBhMjc1NmZlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tj_UbiajE5os-TEvrkkxAKG4mCIO1or8jn5v6z-VgBg",
    };
    
    const OPTIONS = {
        method: "GET",
        headers: HEADER,
    };
    
    const REQUEST = new Request(DISCOVER_URL, OPTIONS);
    return await (await fetch(REQUEST)).json();
};

const SECTION = document.querySelector("section");
const ANTERIOR_BOTON = document.querySelector("#anterior");
const SIGUIENTE_BOTON = document.querySelector("#siguiente");
let current_page;
let current_json;

document.addEventListener("DOMContentLoaded", async () => {
    current_json = await cargarPagina();
    console.log(current_json);
});

ANTERIOR_BOTON.addEventListener("click", async () => {
    debugger
    if (current_json.page !== 1) {
        SECTION.textContent = "";
        let current_page = getLocalSt("current_page", Number);
        current_page--;
        localStorage.setItem("current_page", current_page);
        current_json = await cargarPagina()
    }
});

SIGUIENTE_BOTON.addEventListener("click", async () => {
    if (current_json.page !== current_json.total_pages) {
        SECTION.textContent = "";
        let current_page = getLocalSt("current_page", Number);
        current_page++;
        localStorage.setItem("current_page", current_page);
        current_json = await cargarPagina()
    }
});