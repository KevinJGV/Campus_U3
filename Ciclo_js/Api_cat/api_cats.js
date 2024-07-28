"use strict";

// Comprobacion de ejecucion en navegador
if (!window.location.href.includes(".html")) {
    console.log(
        "%cEjecutar con .html con plantilla HTML5 para más placer",
        "color: black; background-color: yellow; font-size: 20px; font-weight: bold"
    );
}

// Getter de fetching a TheCatAPI, obtiene Json con datos decodificados
async function getting_data(req_object) {
    return await (await fetch(req_object)).json();
}

// Resultados de consultas
let queriesResults = {
    res1: [],
    res2: [],
    res3: [],
    res4: [],
    res5: [],
    res6: [],
    res7: [],
    res8: [],
    res9: [],
    res10: [],
    res11: {},
    res12: {},
    res13: [],
    res14: [],
    res15: [],
    res16: [],
    res17: [],
    res18: [],
    res19: [],
    res20: [],
}

// Obtener informacion basica
async function general_info(_cat) {
    return {
        name: _cat.name,
        image: `https://cdn2.thecatapi.com/images/${_cat.reference_image_id}.jpg`,
        temperament: _cat.temperament,
    };
}

// 1 CONSULTA -  Descripción de los gatos
async function query1(all_cats) {
    for (let _cat of all_cats) {
        queriesResults.res1.push({
            ...(await general_info(_cat)),
            description: _cat.description,
            life_span: _cat.life_span,
            vcahospitals_url: _cat.vcahospitals_url,
        });
    }
}

// 2 <-> 10 CONSULTA -  Gatos independientes, Gentiles, Sociales, Jugetones, Afectivos, Curiosos, Leales, Relajados y Demandantes
async function query2_10(all_cats) {
    const temperament = [
        "Independent",
        "Gentle",
        "Social",
        "Playful",
        "Affectionate",
        "Curious",
        "Loyal",
        "Relaxed",
        "Demanding",
    ];
    const filtred_cats = temperament.map((temp) =>
        all_cats.filter((cat) => cat.temperament.includes(temp))
    );
    for (const query_res of filtred_cats) {
        for (let _cat of query_res) {
            queriesResults[`res${filtred_cats.indexOf(query_res) + 2}`].push({
                ...(await general_info(_cat)),
            });
        }
    }
}

// 11 CONSULTA -  Por origen
async function query11(all_cats) {
    let nations = [];
    for (let cat of all_cats) {
        if (!nations.includes(cat.origin)) {
            nations.push(cat.origin);
        }
    }
    let origins_object = {};
    for (let origin of nations) {
        let filtred_cats = all_cats.filter((cat) => cat.origin === origin);
        origins_object[origin] = await Promise.all(
            filtred_cats.map(async (cat) => {
                return await general_info(cat);
            })
        );
    }
    queriesResults.res11 = origins_object;
}

// 12 CONSULTA -  Por tamaño
async function query12(all_cats) {
    let weights = [];
    for (let cat of all_cats) {
        if (!weights.includes(cat.weight.metric)) {
            weights.push(cat.weight.metric);
        }
    }
    let origins_object = {};
    for (let weight of weights) {
        let filtred_cats = all_cats.filter((cat) => cat.weight.metric === weight);
        origins_object[weight] = await Promise.all(
            filtred_cats.map(async (cat) => {
                return await general_info(cat);
            })
        );
    }
    queriesResults.res12 = origins_object;
}

// 13 <-> 19 CONSULTA -  Más adaptables, afectivos, energeticos, amigabilidad (Niños)(Perros)(Desconocidos) e inteligentes
async function query13_19(all_cats) {
    const attributes = [
        "adaptability",
        "affection_level",
        "energy_level",
        "child_friendly",
        "dog_friendly",
        "stranger_friendly",
        "intelligence",
    ];
    const filtred_cats = attributes.map((attribute) =>
        all_cats.filter((cat) => cat[attribute] === 5)
    );
    for (const query_res of filtred_cats) {
        for (let _cat of query_res) {
            queriesResults[`res${filtred_cats.indexOf(query_res) + 13}`].push({
                ...(await general_info(_cat)),
            });
        }
    }
}

// 20 CONSULTA -  Gatos Naturales
async function query20(all_cats) {
    const filtred_cats = all_cats.filter((cat) => cat.natural === 1);
    for (let cat of filtred_cats) {
        queriesResults.res20.push({
            ...(await general_info(cat)),
        });
    }
}

// Creador de interfaz web
const d = document;

// Opcion de incorporar mas informacion a las tarjetas de gatos
function more_details(cat) {
    const DESCRIPTION = d.createElement("p");
    DESCRIPTION.textContent = cat.description;
    const LIFE_SPAN = d.createElement("p");
    LIFE_SPAN.textContent = `${cat.life_span} años`;
    const STRONG = d.createElement("strong");
    STRONG.textContent = "Promedio de vida: ";
    LIFE_SPAN.insertAdjacentElement("afterbegin", STRONG);
    const HREF = d.createElement("a");
    HREF.setAttribute("href", cat.vcahospitals_url);
    HREF.setAttribute("target", "_blank");
    HREF.setAttribute("ref", "noopener noreferrer");
    HREF.textContent = "See More about this breed";
    return [DESCRIPTION, LIFE_SPAN, HREF];
}

// Generador de cartas para cada gato
function card_generator(cat, query_num) {
    const CARD = d.createElement("div");
    CARD.classList.add("card", "text_center");
    const H3 = d.createElement("h3");
    H3.textContent = cat.name;
    const IMG = d.createElement("img");
    // Función para manejar el error de carga de imagen
    const handleImageError = () => IMG.src = "https://http.cat/images/403.jpg";
    IMG.onerror = handleImageError;
    IMG.src = cat.image;
    const P = d.createElement("p");
    const I = d.createElement("i");
    I.textContent = cat.temperament;
    P.insertAdjacentElement("beforeend", I);
    if (query_num === 1) {
        [H3, IMG, P, ...more_details(cat)].forEach((elem) =>
            CARD.insertAdjacentElement("beforeend", elem)
        );
    } else {
        [H3, IMG, P].forEach((elem) => CARD.insertAdjacentElement("beforeend", elem));
    }
    return CARD;
}

// Generador de estructura predefinida de elemento "details"
function details_generator(title, num) {
    const DETAILS = d.createElement("details");
    const SUMMARY = d.createElement("summary");
    const H2_DETAILS = d.createElement("h2");
    H2_DETAILS.textContent = num !== undefined ? `${num} - ${title}` : title;
    SUMMARY.insertAdjacentElement("beforeend", H2_DETAILS);
    const SECTION = d.createElement("section");
    SECTION.classList.add("flex", "jc_sa");
    return [DETAILS, SUMMARY, SECTION];
}

// Manupulacion del head (estilos/estilos externos)
function headConstructor() {
    const HEADFRAG = d.createDocumentFragment();

    const HLSCRIPT = d.createElement("script");
    HLSCRIPT.setAttribute(
        "src",
        "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.5.0/highlight.min.js"
    );

    const HLLINK = d.createElement("link");
    HLLINK.setAttribute("rel", "stylesheet");
    HLLINK.setAttribute(
        "href",
        "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.5.0/styles/default.min.css"
    );

    const STYLES = d.createElement("style");
    STYLES.innerHTML =
        "*{ box-sizing: border-box; transition: all 0.2s cubic-bezier(.22, .61, .36, 1);}body {font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif; padding-inline: 15cqw}.flex {display: flex; flex-flow: wrap;}.flex_col { display: flex; flex-flow: column;}.all_c{ justify-content: center; justify-items: center; justify-self: center; align-content: center; align-items: center; align-self: center;}.jc_sa {justify-content: space-around;}.text_center{ text-align: center;} .hljs {color:green; background-color: #0D0D0D; border-radius: 7px;} .hljs-punctuation{ color: white;}.hljs-string{ color: #00A67D;} .hljs-number{ color: #DF3079;}summary { border-bottom: 1px solid black; margin: 2px; box-sizing: border-box; opacity: 0.6; user-select: none;}summary:hover{ opacity: 1;}summary::marker { font-size: 1.5rem;}summary h2 { display: inline-block;}.card {width: 210px;} img{width: 200px}:";
    [HLSCRIPT, HLLINK, STYLES].forEach((elem) => HEADFRAG.appendChild(elem));
    HLSCRIPT.addEventListener("load", () => {
        hljs.highlightAll();
    });
    d.head.appendChild(HEADFRAG);
}

// Cuerpo de la pagina
function bodyConstructor(_results) {
    const CONTAINER = d.createElement("container");
    const H1 = d.createElement("h1");
    H1.textContent = "TheCatAPI - 20 Queries";
    const H2_CODE = d.createElement("h2");
    H2_CODE.textContent = "Estructura del HTTPRequest decodificado";
    const PRE = d.createElement("pre");
    const CODE = d.createElement("code");
    CODE.classList.add("json");
    CODE.textContent = `   [
        ...
        {
            "weight": {
            "imperial": "7  -  10",
            "metric": "3 - 5"
            },
            "id": "abys",
            "name": "Abyssinian",
            "cfa_url": "http://cfa.org/Breeds/BreedsAB/Abyssinian.aspx",
            "vetstreet_url": "http://www.vetstreet.com/cats/abyssinian",
            "vcahospitals_url": "https://vcahospitals.com/know-your-pet/cat-breeds/abyssinian",
            "temperament": "Active, Energetic, Independent, Intelligent, Gentle",
            "origin": "Egypt",
            "country_codes": "EG",
            "country_code": "EG",
            "description": "The Abyssinian is easy to care for, and a joy to have in your home. They’re affectionate cats and love both people and other animals.",
            "life_span": "14 - 15",
            "indoor": 0,
            "lap": 1,
            "alt_names": "",
            "adaptability": 5,
            "affection_level": 5,
            "child_friendly": 3,
            "dog_friendly": 4,
            "energy_level": 5,
            "grooming": 1,
            "health_issues": 2,
            "intelligence": 5,
            "shedding_level": 2,
            "social_needs": 5,
            "stranger_friendly": 5,
            "vocalisation": 1,
            "experimental": 0,
            "hairless": 0,
            "natural": 1,
            "rare": 0,
            "rex": 0,
            "suppressed_tail": 0,
            "short_legs": 0,
            "wikipedia_url": "https://en.wikipedia.org/wiki/Abyssinian_(cat)",
            "hypoallergenic": 0,
            "reference_image_id": "0XYvRd7oD",
            "image": {
            "id": "0XYvRd7oD",
            "width": 1204,
            "height": 1445,
            "url": "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"
            }
        },
        ...
    ]`;
    PRE.insertAdjacentElement("beforeend", CODE);
    [H1, H2_CODE, PRE].forEach((nodo) =>
        CONTAINER.insertAdjacentElement("beforeend", nodo)
    );

    const query_names = ["Descripción de los gatos", "Gatos independientes", "Gatos Gentiles", "Gatos Sociales", "Gatos Jugetones", "Gatos Afectivos", "Gatos Curiosos", "Gatos Leales", "Gatos Relajados", "Gatos Demandantes", "Por origen", "Por peso (Kg)", "Más adaptables", "Más afectivos", "Más energeticos", "Más amigabilidad (Niños)", "Más amigabilidad (Perros)", "Más amigabilidad (Desconocidos)", "Más inteligentes", "Gatos Naturales"];
    query_names.forEach(query => {
        let query_num = query_names.indexOf(query) + 1;
        let res_value = _results[`res${query_num}`];
        const [DETAILS, SUMMARY, SECTION] = details_generator(query, query_num);
        if (Array.isArray(res_value)) {
            res_value.forEach(cat => {
                const CARD = card_generator(cat, query_num);
                SECTION.insertAdjacentElement("beforeend", CARD);
            });
        } else if (typeof res_value === 'object') {
            Object.keys(res_value).forEach(countryOrLifespan => {
                const [INNER_DETAILS, INNER_SUMMARY, INNER_SECTION] = details_generator(countryOrLifespan);
                res_value[countryOrLifespan].forEach(cat => {
                    const CARD = card_generator(cat);
                    INNER_SECTION.insertAdjacentElement("beforeend", CARD);
                });
                [INNER_SUMMARY, INNER_SECTION].forEach((elem) =>
                    INNER_DETAILS.insertAdjacentElement("beforeend", elem)
                );
                SECTION.insertAdjacentElement("beforeend", INNER_DETAILS);
            });
        }
        [SUMMARY, SECTION].forEach((elem) =>
            DETAILS.insertAdjacentElement("beforeend", elem)
        );
        CONTAINER.insertAdjacentElement("beforeend", DETAILS);
    });
    d.body.insertAdjacentElement("beforeend", CONTAINER);
}

// Orden de ejecucion head/body modulados por aparte
async function creadorPagina(_results) {
    headConstructor();
    bodyConstructor(_results);
}

// Procedimiento de todas las consultas una vez cargue la pagina, solo se realiza una solicitud a la API de esta forma
document.addEventListener("DOMContentLoaded", async () => {
    // Definicion de constantes
    const URL = "https://api.thecatapi.com/v1/breeds";
    const HEADER = {
        "x-api-key": "live_uuWWnNwsNHXdaFFcUNJugOejyOs5mDwcz1CDzFXAQBSceEnuFw5xfLgXLDjDIT47",
        "Content-Type": "application/json",
    };
    const options = {
        method: "GET",
        headers: HEADER,
    };
    const req_object = new Request(URL, options);

    const all_cats = await getting_data(req_object);

    // Ejecución de consultas
    await query1(all_cats);
    await query2_10(all_cats);
    await query11(all_cats);
    await query12(all_cats);
    await query13_19(all_cats);
    await query20(all_cats);
    console.log(queriesResults);

    // Envio de datos al DOM
    await creadorPagina(queriesResults);
});
