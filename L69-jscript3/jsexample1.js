//var a=0;
//incrementTrice(a);
//console.log(a);
/*console.log(1=="1"); //true
console.log(1==="1");//false
console.log('1'=="1"); //true
console.log('1'==="1"); //true
console.log(true==1); //true
console.log(true===1);//false

console.log(1!="1");
console.log(1!=="1");
console.log('1'!="1"); 
console.log('1'!=="1");
console.log(true!=1); 
console.log(true!==1);*/

//(2>3) ? "так не будет" : alert("paradox");
//alert(2.71**Math.log(20));

//[] - myMap['человек1']; + просто как в джаве с массивами
// + инициализация массива
//var myArray = [2,5,true, "x"];
//console.log(myArray[3]);

//JAVA:
//for (int a : arrayOfInt){
//	System.out.println(a)
//}
//JAVASCRIPT:
//for (let a in arrayOfInt){
//	console.log(a);
//}

//console.log(2 in [33,222,2223]);
//console.log(22 in [1,2,3]);

//управляющие конструкции:

var a,b,c,d;
//.......
a=2;
b=true;
c="v";
d=undefined;
[a,b,c,d]=[2, true, "v", undefined];

//var array2=[for (i of numbers) i*2]; пока не стандарт


function incrementTrice(chislo){
	chislo = (chislo=chislo+1, chislo=chislo+1, chislo+1);
	console.log(chislo);
	
	for (let i=(console.log("присваиваю и в " +
			"начале цикла"), 0); i<10; i++) {
		console.log(i);
	}
	
}