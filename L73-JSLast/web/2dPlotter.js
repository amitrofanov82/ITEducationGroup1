/**
 * 
 */

var HtmlPlotterClass = function(mathFunction, canvas) {
	
	this.canvas=canvas;
	this.context2d = canvas.getContext("2d");
	this.mathFunction = mathFunction;
	this.colors = ['#f00', '#0f0', '#00f','#0ff'];
	this.x0 = Math.round(this.canvas.width/2);
	this.y0 = Math.round(this.canvas.height/2);
	
	this.calculateY = function(x){
		let jsCode = "return " + this.mathFunction;
		let f = new Function("x", jsCode);
		return f(x);
	}
	
	this.draw = function() {
		console.log("draw method called");
		console.log(this.calculateY(2));
		this.context2d.lineWidth=2;
		this.context2d.strokeStyle = this.colors[3]; //цвет линии
		this.context2d.beginPath();
		//Вертикальная линия
		this.context2d.moveTo(this.x0, 0);
		this.context2d.lineTo(this.x0, this.canvas.height);
		//горизонтальная линия
		this.context2d.moveTo(0, this.y0);
		this.context2d.lineTo(this.canvas.width, this.y0);
		
		this.context2d.stroke();
		
		var grafik = [];
		for (let i = -250; i<250; i++) {
			grafik[i] = Math.round(this.calculateY(i));
		}
		
		this.context2d.beginPath();
		this.context2d.moveTo(0, grafik[0]+250); // так как 0 для Y вверху на экране
		for (let i = -250; i<250; i++) {
			this.context2d.lineTo(i+250, grafik[i]+250);
		}
		this.context2d.stroke();

	}
	
}


