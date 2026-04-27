export class Suma {
    private _numero1: number;
    private _numero2: number;

    constructor(numero1: number, numero2: number) {
        this._numero1 = numero1;
        this._numero2 = numero2;
    }

    get getSuma(): number {
        return this._numero1 + this._numero2;
    }

    set setNumero1(nuevoNumero: number) {
        this._numero1 = nuevoNumero;
    }

    set setNumero2(nuevoNumero: number) {
        this._numero2 = nuevoNumero;
    }

    mostrarInformacion() {
        console.log(this.getSuma);
    }

}