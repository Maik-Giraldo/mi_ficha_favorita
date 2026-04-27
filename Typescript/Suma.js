"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Suma = void 0;
var Suma = /** @class */ (function () {
    function Suma(numero1, numero2) {
        this._numero1 = numero1;
        this._numero2 = numero2;
    }
    Object.defineProperty(Suma.prototype, "getSuma", {
        get: function () {
            return this._numero1 + this._numero2;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Suma.prototype, "setNumero1", {
        set: function (nuevoNumero) {
            this._numero1 = nuevoNumero;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Suma.prototype, "setNumero2", {
        set: function (nuevoNumero) {
            this._numero2 = nuevoNumero;
        },
        enumerable: false,
        configurable: true
    });
    Suma.prototype.mostrarInformacion = function () {
        console.log(this.getSuma);
    };
    return Suma;
}());
exports.Suma = Suma;
