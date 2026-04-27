class personaje {
    nombre;
    ki;
    vida;
    fase;
    raza;
    poderCurativo;

    constructor(nombre, ki, vida, fase, raza, poderCurativo) {
        this.nombre = nombre;
        this.ki = ki;
        this.vida = vida;
        this.fase = fase;
        this.raza = raza;
        this.poderCurativo = poderCurativo;
    }

    mostrarInformacion() {
        console.log("El nombre es: " + this.nombre);
        console.log("El ki es: " + this.ki);
        console.log("La vida es: " + this.vida);
        console.log("La fase es: " + this.fase);
        console.log("La raza es: " + this.raza);
        console.log("El poder curativo es: " + this.poderCurativo);
    }

    atacar(objetivo) {
        console.log(this.nombre + " atacó a " + objetivo.nombre + " y le causó " + this.ki  + " de daño");
        objetivo.vida -= this.ki;
    }

    curar(objetivo) {
        console.log(this.nombre + " curó a " + objetivo.nombre + " y le dió " + this.poderCurativo  + " de vida");
        objetivo.vida += this.poderCurativo;

        if(objetivo.vida > 5000) {
            objetivo.vida = 5000;
        } else {
            objetivo.vida = objetivo.vida;
        }
    }
}

const goku = new personaje("Gokú", 2000, 5000, "Super sayayin", "Sayayin", 0);
const vegeta = new personaje("Vegeta", 1500, 5000, "Super sayayin", "Sayayin", 0);
const dende = new personaje("Dendé", 1000, 2000, "base", "Namekiano", 5000);

goku.mostrarInformacion();
console.log("\n");
vegeta.mostrarInformacion();
console.log("\n");
goku.atacar(vegeta);
console.log("\n");
vegeta.mostrarInformacion();
console.log("\n");
dende.curar(vegeta);
console.log("\n");
vegeta.mostrarInformacion();