"use strict";

// Definicion de datos
const tareas = [
    {
        id:0,
        descripcion:"Traer el pan",
        responsable:"Carlos",
        estado:"Finalizada"
    },
    {
        id:1,
        descripcion:"Llevar el domi",
        responsable:"Camila",
        estado:"Finalizada"
    },
    {
        id:2,
        descripcion:"loquesea",
        responsable:"responsable1",
        estado:"Pendiente"
    },
    {
        id:3,
        descripcion:"Comer con la mujer",
        responsable:"Kevina",
        estado:"Finalizada"
    },
    {
        id:4,
        descripcion:"Ir al parque",
        responsable:"Sr Mittens",
        estado:"Finalizada"
    },
];


function alerts(op, show_data) {
    if (op === 1) {
        return promptn(
            "=".repeat(5) +
                " Bienvenido a To-Do List v0.1 " +
                "=".repeat(5) + "\n\t\tTareas En Curso:\n" + show_data + 
                "\n1 - Agregar tarea\n2 - Eliminar tarea\nAny - Salir"
        );
    } else if (op === 2) {
        return promptn("ID de la tarea a eliminar");
    } else if (op === 3) {
        return promptn("ID de la nueva tarea");
    } else if (op === "quit") {
        alert("Cerrando To-Do List...");
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
async function val_num(num, msj = null) {
    while (true) {
        if (msj == null) {
            if (!Number.isFinite(num)) {
                num = alerts("bad_num");
                if (num === null) {
                    break;
                }
            } else {
                return num;
            }
        } else if (msj === 1) {
            let string = await cargador_tareas(tareas)
            return val_num(alerts(msj,string));
        } else {
            return val_num(alerts(msj));
        }
    }
}

async function cargador_tareas(datos) {
    const header = [" ID","DESCRIPCIÓN","RESPONSABLE","ESTADO "];
    let blank = header.join(" | ") + "\n";
    for (let tarea of datos) {
            blank += ` ${tarea.id} | ${tarea.descripcion} | ${tarea.responsable} | ${tarea.estado} \n`
        };
    return new Promise((res) => setTimeout(res,3000,blank))
}

async function Agregar(tareas) {
    const new_id = await val_num(undefined,3);
    const desc = prompt("Descripcion de la tarea");
    const respons = prompt("Responsable de la tarea");
    const task = {
        id:new_id,
        descripcion:desc,
        responsable:respons,
        estado:"Pendiente"
    }
    tareas.push(task)
}
async function Borrar(tareas) {
    const index = await val_num(undefined,2);
    if (index <= tareas.length - 1) {
        const deleted = tareas.splice(index,1);
        console.log(`Tarea Eliminada:\nID: ${deleted.id}\nDESCRIPCIÓN: ${deleted.descripcion}\nRESPONSABLE: ${deleted.responsable}`);
    };
}

// Menu principal
async function main() {
    debugger
    while(true){
        let opcion = await val_num(undefined, 1);
        console.log(opcion)
        if (opcion === 1) {
            await Agregar(tareas)
        } else if (opcion === 2) {
            await Borrar(tareas)
        } else {
            alerts("quit");
            break
        };
    }
}


main()
