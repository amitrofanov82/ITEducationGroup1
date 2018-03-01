
function OurSimpleClass(){
	console.log("nachalo konstruktora");
	console.log(this);
	
	this.b = 0;
	
	this.field1 = "value1";
	this.field2 = Math.random();
	
	this.getField2 = function (){
		console.log("getter is here")
		return this.field2;
	}
	
	this.doSomething = function(){
		console.log("f*k off")	
	}
	
	this.setB = function(novyjB){
		b = novyjB;
	}
	
	this.getB = function(novyjB){
		return b;
	}
	
	
}

function ChildOfSimpleClass(){
	this.constructor = OurSimpleClass;
	this.constructor()
	delete this.constructor;
	
	//продолжаем новые поля и методы
	
}
var child = new ChildOfSimpleClass();

//var o = OurSimpleClass();
//var o = {}
//o.constructor = OurSimpleClass;
//console.log("pered vyzovom konstruktora");
//o.constructor()
//delete o.constructor;
//console.log(o);
/*
var o1 = new OurSimpleClass();
var o2 = new OurSimpleClass();
var o3 = new OurSimpleClass();

o1.field1 = "newField1ForO1";
o2.field1 = "newField1ForO2";
o3.field1 = "newField1ForO3";

o1.b = "newBForO1 as new field";
o2.b = "newBForO2 as new field";
o3.b = "newBForO3 as new field";

o1.setB("newBForO1 with setter");
o2.setB("newBForO2 with setter");
o3.setB("newBForO3 with setter");

console.log(o1.getB());
console.log(o2.getB());
console.log(o3.getB());
console.log(o1.b);
console.log(o2.b);
console.log(o3.b);
*/















//var o = new Object();
//o.novayaFunkciya = function(){return 1;}


//var objectBasedOnClass = new OurSimpleClass();

//console.log(objectBasedOnClass);
//console.log(typeof objectBasedOnClass);

