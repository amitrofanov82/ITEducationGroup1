/**/
var charArray = ["","a","b","c","d","e","f","g","h"];
var figureSelected = false;
var figureBuffer = "";

function colorOfSquare(i,j) {
	if(i % 2 === 0){
		if(j % 2 === 0){
			return "white";
		}else{
			return "black";
		}
	}else{
		if(j % 2 === 0){
			return "black";
		}else{
			return "white";
		}
	}
}

function createFigure(i,j){
	if(i === 2){
		//white pawn
		return "images/wp.png";
	}
	if(i === 7){
		//black pawn
		return "images/bp.png";
	}

	if(i === 1){
		if(j === 1 || j === 8){
			//white rock
			return "images/wr.png";
		}
		if(j === 2 || j === 7){
			//white knight
			return "images/wk.png";
		}
		if(j === 3 || j === 6){
			//white bishop
			return "images/wb.png";
		}
		if(j === 4){
			//white queen
			return "images/wq.png";
		}
		if(j === 5){
			//white king
			return "images/wking.png";
		}
	}
	if(i === 8){
		if(j === 1 || j === 8){
			//black rock
			return "images/br.png";
		}
		if(j === 2 || j === 7){
			//black knight
			return "images/bk.png";
		}
		if(j === 3 || j === 6){
			//black bishop
			return "images/bb.png";
		}
		if(j === 4){
			//black queen
			return "images/bq.png";
		}
		if(j === 5){
			//black king
			return "images/bking.png";
		}
	}
	else{
		return"";
	}
}


function drowChessBoard() {
	var chessboard = document.createElement("table");
	chessboard.setAttribute("id","chess-board");
	for(var i = 0;i<9;i++){
		var row = document.createElement("tr");
		for(var j = 0;j<9;j++){
			if(i == 0){
				var corditeate = document.createElement("td");
				corditeate.setAttribute("class","corditeate");
				corditeate.setAttribute("bgcolor", "grey");
				corditeate.innerHTML = charArray[j];
				row.appendChild(corditeate);
				continue;
			}
			if(j == 0){
				var corditeate = document.createElement("td");
				corditeate.setAttribute("class","corditeate");
				corditeate.setAttribute("bgcolor", "grey");
				corditeate.innerHTML = i;
				row.appendChild(corditeate);
				continue;
			}

			var square = document.createElement("td");
			square.setAttribute("class","square");
			square.setAttribute("bgcolor", colorOfSquare(i,j));

			var srcFigure = createFigure(i,j);
			var figure = document.createElement("img");
			figure.setAttribute("class","figure");
			figure.addEventListener("click", onClick);
			if(srcFigure != ""){
				figure.setAttribute("src",  srcFigure);
			}else{
				figure.setAttribute("src",  "");
			}
			square.appendChild(figure);
			row.appendChild(square);
		}
		chessboard.appendChild(row);
	}
	document.body.appendChild(chessboard);
}

function onClick(){
	if(figureSelected){
		this.setAttribute("src", figureBuffer);
		figureBuffer = "";
		figureSelected = false;
	}else{
		figureBuffer = this.getAttribute("src");
		this.removeAttribute("src");
		figureSelected = true;
	}
}
