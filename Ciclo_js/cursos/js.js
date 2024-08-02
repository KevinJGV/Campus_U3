"use strict";

let detailsNode = document.querySelectorAll("details");
const NAME_COURSE = document.querySelector("#name");
const DESCRP_COURSE = document.querySelector("#descr");
const CONTENT_COURSE = document.querySelector("#content");
const FORM_BUTTON_CREATE = document.querySelector("#form_button");
const FORM_BUTTON_FILTER = document.querySelector("#form_button_q");
const SECTION = document.querySelector("section");

async function gettData() {
    return await new Promise((resolve) => {
        setTimeout(() => {
            localStorage.setItem("title", NAME_COURSE.value);
            NAME_COURSE.value = "";
            localStorage.setItem("description", DESCRP_COURSE.value);
            DESCRP_COURSE.value = "";
            localStorage.setItem("content", CONTENT_COURSE.value);
            CONTENT_COURSE.value = "";
            resolve();
        }, 1500);
    });
};

async function gettCards() {
    return await new Promise((resolve) => {
        setTimeout(() => {
            let cards = document.querySelectorAll(".card");
            const NAME_FILTER = document.querySelector("#name_q");
            const DESCRP_FILTER = document.querySelector("#descr_q");
            const CONTENT_FILTER = document.querySelector("#content_q");
            cards.forEach(card => {
                AQUI NOS QUEDAMOS
            })
            resolve()            
        }, 1500);
    })
};

function card_constructor() {
    if (
        localStorage.getItem("title") !== "" &&
        localStorage.getItem("description") !== "" &&
        localStorage.getItem("content") !== ""
    ) {
        const CARD = document.createElement("div");
        CARD.classList.add("card");
        const TITLE = document.createElement("h5");
        TITLE.classList.add("text_center");
        const TITLE_strong = document.createElement("strong");
        TITLE_strong.textContent = "Curso: ";
        const TITLE_span = document.createElement("span");
        TITLE_span.textContent = localStorage.getItem("title");
        [TITLE_strong, TITLE_span].forEach((node) =>
            TITLE.insertAdjacentElement("beforeend", node)
        );
        const IMG_BOX = document.createElement("div");
        IMG_BOX.classList.add("img_box", "flex_col", "j-all_c");
        const IMG = document.createElement("img");
        IMG.src = "https://cdn-icons-png.flaticon.com/512/3426/3426653.png";
        IMG.classList.add("text_center");
        IMG_BOX.insertAdjacentElement("beforeend", IMG);
        const DESCRIPTION_p = document.createElement("p");
        DESCRIPTION_p.classList.add("block", "text_center");
        const DESCRIPTION_i = document.createElement("i");
        DESCRIPTION_i.insertAdjacentText(
            "beforeend",
            localStorage.getItem("description")
        );
        DESCRIPTION_p.insertAdjacentElement("beforeend", DESCRIPTION_i);
        const H6 = document.createElement("h6");
        H6.classList.add("text_center");
        H6.textContent = "Contenido academico";
        const CONTENT = document.createElement("p");
        CONTENT.classList.add("content");
        CONTENT.insertAdjacentText(
            "beforeend",
            localStorage.getItem("content")
        );
        const EDIT_BUTTON = document.createElement("button");
        EDIT_BUTTON.classList.add("pointer");
        EDIT_BUTTON.id = "edit_button";
        EDIT_BUTTON.textContent = "Editar";
        const DEL_BUTTON = document.createElement("button");
        DEL_BUTTON.classList.add("pointer");
        DEL_BUTTON.id = "del_button";
        DEL_BUTTON.textContent = "Eliminar";
        [
            TITLE,
            IMG_BOX,
            DESCRIPTION_p,
            H6,
            CONTENT,
            EDIT_BUTTON,
            DEL_BUTTON,
        ].forEach((node) => CARD.insertAdjacentElement("beforeend", node));
        return CARD;
    } else alert("Debe llenar todos los campos para agregar un nuevo curso");
}

function updateButtons() {
    let edit_buttons = document.querySelectorAll("#edit_button");
    let del_buttons = document.querySelectorAll("#del_button");

    edit_buttons.forEach((button) => {
        button.addEventListener("click", (event) => {
            let h5_card = event.target.parentElement.querySelector("span");
            let prompt_R = validarPrompt(prompt("Nuevo nombre del curso"));
            if (prompt_R !== null) {
                h5_card.textContent = "";
                h5_card.textContent = prompt_R;
            }
            let descr_card = event.target.parentElement.querySelector("i");
            prompt_R = validarPrompt(prompt("Nueva descripción del curso"));
            if (prompt_R !== null) descr_card.textContent = prompt_R;
            let content_card =
                event.target.parentElement.querySelector(".content");
            prompt_R = validarPrompt(prompt("Nuevo contenido del curso"));
            if (prompt_R !== null) content_card.textContent = prompt_R;
        });
    });

    del_buttons.forEach((button) => {
        button.addEventListener("click", (event) => {
            event.target.parentElement.remove();
        });
    });
};

function colapse_details() {
    detailsNode = document.querySelectorAll("details");

    detailsNode.forEach(detail => {
        detail.addEventListener("click", () => {
            detailsNode.forEach(others => {
                if (others !== detail) others.removeAttribute("open");
            })
        })
    })
};

function validarPrompt(msg) {
    while (true) {
        if (msg === "") {
            msg = prompt("Ingrese algun contenido");
        } else {
            return msg;
        }
    }
};

FORM_BUTTON_CREATE.addEventListener("click", async () => {
    await gettData();
    const ITEM = card_constructor();
    SECTION.insertAdjacentElement("beforeend", ITEM);
    updateButtons();
});

FORM_BUTTON_FILTER.addEventListener("click", async () => {

})
updateButtons();
colapse_details();