/**
 * 
 */
//var sayMeow="МЯУ";

function sayMeow(){
	alert("MЯУ");
}


function doCommand(command){
	if (typeof command == 'function'){
		command();
	} else {
		alert(command);
	}
}

function printTypes(){
	console.log(Math.LN10);
	var a;
	var a2=[1,2];
	//var c
	console.log(typeof "Hello");
	console.log("Hello"[2]+"Hello"[3]);
	console.log("Hello".substring(2, 5));
	console.log(typeof 'Hello');
	console.log(typeof 'A')
	console.log(typeof Symbol('A'));
	console.log(typeof sayMeow);
	console.log(typeof sayMeow());
	console.log(typeof 10)
	console.log(typeof 10000000000);
	console.log(typeof 10.123635436);console.log(typeof true);

	console.log(typeof true+1)
	console.log(typeof 
			(true+1))
	console.log(typeof [a])
	console.log(typeof a2);
	console.log(typeof null);
	
	if (a = undefined) {
		//....
	}
	
}

function printChessBoard(){
	document.writeln("<br/>");
	document.writeln("<table>");
		for (var i=0; i<8; i++) {
			document.writeln("<tr>");
			for (var j=0; j<8; j++){
				document.writeln('<td style="height: 30px; width:30px; background-color: black ">');
				document.writeln("</td>");
			}
			document.writeln("</tr>");
		}
	
	document.writeln("</table>");
}



