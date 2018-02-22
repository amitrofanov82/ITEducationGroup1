"Привет, мир!".length;  //тип String
"Привет, мир!".toUpperCase(); //и прочие типичные для стринга методы 
[1, 2].forEach(console.log); //и прочие типичные для списка\очереди\стэка методы. Например pop push shift unshift sort...
console.log( 12.355.toFixed(1) ); // 12.3 тип Number
console.log( 12..toFixed(1) ); // 12.0

var myObject = {};
var myObject2 = new Object();

myObject.newProperty="something";
myObject.newProprety="updatedValue";
delete myObject.newProprety;
myObject.firstMethod = function(){
	var a=0;
	var b=5;
	console.log(b/a + this.newProperty);
}

myObject.firstMethod();
myObject2.firstMethod = myObject.firstMethod;
myObject2.firstMethod();
console.log('--------------------');
var massiv = [1,2];
for (var svoystvo in myObject) {
	console.log(svoystvo + 
			"=" + myObject[svoystvo]);
}
myObject.svoystvo = undefined;
if ("svoystvo" in myObject) {
	console.log(svoystvo + 
			"=" + myObject[svoystvo]);
} else {
	console.log("Nie ma svoystva")
}

if (myObject.svoystvo !== undefined) {
	console.log(svoystvo + 
			"=" + myObject[svoystvo]);
} else {
	console.log("Nie ma znacznia svoystva")
}

console.log(myObject.asdfgh);//ok, undefined
//console.log(myObject.asdfgh.dgh);//not ok, NPE


myObject.svoystvo = "new Value";
myObject[svoystvo] = "new Value again"; 



var user1 ={
	name: "Vasya",
	sex: "malchik",
	action: function(){console.log("smotryu futbol")}
};
var user2 ={
		name: "Vasya",
		sex: "malchik",
		action: function(){console.log("smotryu futbol")}
};
var user3 ={
		name: "Elleonora",
		sex: "lady",
		action: function(){console.log("smotryu dom2 i odevayus")}
};

var arr = [];
//arr[1000] = 'znachenie';
arr[1000] = undefined; //(1001 anyway)
console.log(arr.length); // 1001 

var arr2 = {length:0}
arr2[100] = "newVal";
alert(arr2.length)













