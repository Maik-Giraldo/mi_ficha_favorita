// Funcion declarada
// function saludar(nombre) {
//     return "Hola " + nombre;
// }

// console.log(saludar("Maiik"));

// -------------------------------------------------------


// // Funcion Expresada
// const saludar = function (nombre) {
//     return "Hola " + nombre;
// };

// console.log(saludar("Maiik"));

// // -------------------------------------------------------

// Arrow Function o función flecha
// const saludar = (nombre) => 
//     "Hola " + nombre;

// console.log(saludar("Maiik"));

// // -------------------------------------------------------

// Funcion con parametros por defecto
// function esPar(numero) {
//     if(numero % 2 == 0) {
//         return "es par";
//     } else {
//         return " es impar";
//     }

//   return numero % 2 == 0 ? "es par" : "es impar";
// }

// console.log(sumar());


const operacion = prompt("Ingrese la operacion").toLowerCase();
const numero1 = Number(prompt("Ingrese numero 1"));
const numero2 = Number(prompt("Ingrese numero 2"));

function sumar(numero1, numero2) {
    return numero1 + numero2;
}

function restar(numero1, numero2) {
    return numero1 - numero2;
}

switch (operacion) {
    case "sumar":
        alert(sumar(numero1, numero2));
        break;
    case "restar":
        alert(restar(numero1, numero2))
        break;
    default:
        alert("No es una operacion valida");
        break;
}