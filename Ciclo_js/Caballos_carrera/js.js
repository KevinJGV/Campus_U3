"use strict";

// Definición de funcion generica para mensajes en el ejercicio
function mensajes_de_ejecucion(op = undefined) {
    if (op === 1) {
        return promptn(
            "=".repeat(5) +
                " Bienvenido a la casa de apuestas 'HorseBet' " +
                "=".repeat(5) +
                "\n1 - Iniciar apuesta\n2 - Salir"
        );
    } else if (op === 2) {
        alert("Iniciar apuesta\nSe aposto $50.000 USD al Caballo 3");
    } else if (op === 3) {
        console.log("Carrera iniciada");
    } else if (op === "quit") {
        alert("Cerrando HorseBet...");
    } else if (op === "bad_num") {
        return promptn(
            "=".repeat(5) +
                " Entrada invalida " +
                "=".repeat(5) +
                "\nIngrese un valor númerico"
        );
    } else {
        console.error(
            "Mensaje no seleccionado correctamente para mensajes_de_ejecucion()"
        );
    }
}

// Definición de funcion generica prompt que convierte el mensaje en Number
function promptn(msj) {
    let res = prompt(msj);
    if (res === "") {
        return res;
    } else {
        return Number(res);
    }
}

// Definición de funcion generica que valida la entrada de valores numericos, permite al definir msj mostrar un prompt y validar dicha entrada recursivamente
function val_num(num, msj = null) {
    while (true) {
        if (msj == null) {
            if (!Number.isFinite(num)) {
                num = mensajes_de_ejecucion("bad_num");
                if (num === null) {
                    break;
                }
            } else {
                return num;
            }
        } else {
            return val_num(mensajes_de_ejecucion(msj));
        }
    }
}

async function apuesta() {
    mensajes_de_ejecucion(2);
    const CABALLO_1 = new Promise((res) => setTimeout(res, 2300, "Caballo 1"));
const CABALLO_2 = new Promise((res) => setTimeout(res, 1500, "Caballo 2"));
const CABALLO_3 = new Promise((res) => setTimeout(res, 1200, "Caballo 3"));
const CABALLO_4 = new Promise((res) => setTimeout(res, 1000, "Caballo 4"));
const CABALLO_5 = new Promise((res) => setTimeout(res, 2000, "Caballo 5"));
    const inicio = Date.now();
    const res = await Promise.all([
        CABALLO_1.then((res) => ({ resultado:res, tiempo: Date.now() - inicio })),
        CABALLO_2.then((res) => ({ resultado:res, tiempo: Date.now() - inicio })),
        CABALLO_3.then((res) => ({ resultado:res, tiempo: Date.now() - inicio })),
        CABALLO_4.then((res) => ({ resultado:res, tiempo: Date.now() - inicio })),
        CABALLO_5.then((res) => ({ resultado:res, tiempo: Date.now() - inicio })),
    ]);
    console.log(res)
    return res
}

function main() {
    let opcion = val_num(undefined, 1);
    let resultados = opcion === 1 ? apuesta() : mensajes_de_ejecucion("quit");
    // resultados.sort((a,b) => a-b);
    for(let resultado of resultados) {
        resultado
    }
}

// Inicializar multiples promesas


main()
