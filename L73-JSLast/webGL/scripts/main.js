/* MAIN SCRIPT FOR THE WebGL DEMONSTRATION */

var cubeRotation = 0.0;// с какой стороны начать отрисовку //TODO баловаться
var rotateOn = true;
var render;

/*****************************************************************************/
function main() {
	positionControl();

	const canvas = document.querySelector("#glCanvas");
	// Иницифлизация контента GL
	const gl = canvas.getContext("webgl");

	if (!gl) {
	alert("WebGl потерялся. Шоу отменяеется");
	return;
	}

	/************************************/
	// Vertex shader program
	const vsSource = `
	attribute vec4 aVertexPosition;
	attribute vec4 aVertexColor;

	uniform mat4 uModelViewMatrix;
	uniform mat4 uProjectionMatrix;

	varying lowp vec4 vColor;

	void main() {
	  gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition;
	  vColor = aVertexColor;
	}
	`;
	// Fragment shader program
	const fsSource = `
		varying lowp vec4 vColor;

	    void main(void) {
	      gl_FragColor = vColor;
	    }
	`;

	const shaderProgram = initShaderProgram(gl, vsSource, fsSource);

	const programInfo = {
	  program: shaderProgram,
	  attribLocations: {
		vertexPosition: gl.getAttribLocation(shaderProgram, 'aVertexPosition'),
		vertexColor: gl.getAttribLocation(shaderProgram, 'aVertexColor'),
	  },
	  uniformLocations: {
		projectionMatrix: gl.getUniformLocation(shaderProgram, 'uProjectionMatrix'),
		modelViewMatrix: gl.getUniformLocation(shaderProgram, 'uModelViewMatrix'),
	  },
	};
	/************************************/
	// Здесь мы называем процедуру, которая строит все объекты, которые мы будем рисовать.
  	const buffers = initBuffers(gl);


	var then = 0;
	// Повторно отрисовать сцену
	render = function (now) {
		now *= 0.001;  // конвертировать в секундах //TODO баловаться
		const deltaTime = now - then;
		then = now;

		if(rotateOn){
			drawScene(gl, programInfo, buffers, deltaTime);
			requestAnimationFrame(render);
		}
	}
		requestAnimationFrame(render);
}

/*****************************************************************************/
/*	Инициализация шейдерных програм, чтобы WebGL знал, как рисовать данные	 */
function initShaderProgram(gl, vsSource, fsSource) {
	const vertexShader = loadShader(gl, gl.VERTEX_SHADER, vsSource);
	const fragmentShader = loadShader(gl, gl.FRAGMENT_SHADER, fsSource);

	// Создание шейдерной программы
	const shaderProgram = gl.createProgram();
	gl.attachShader(shaderProgram, vertexShader);
	gl.attachShader(shaderProgram, fragmentShader);
	gl.linkProgram(shaderProgram);

	// If creating the shader program failed, alert
	if (!gl.getProgramParameter(shaderProgram, gl.LINK_STATUS)) {
	alert('Свет отключен за неуплату или потому что: ' + gl.getProgramInfoLog(shaderProgram));
	return null;
	}
	return shaderProgram;
}

/*****************************************************************************/
/*	Создает шейдер данного типа, загружает источник и компилирует его		 */
function loadShader(gl, type, source) {
	const shader = gl.createShader(type);

	// Отправка источника в шейдерный объект
	gl.shaderSource(shader, source);

	// Компиляция шейдерной программы
	gl.compileShader(shader);

	// See if it compiled successfully
	if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
	alert('Лампочки при упаковке были разбиты потому что: ' + gl.getShaderInfoLog(shader));
	gl.deleteShader(shader);
	return null;
	}
	return shader;
}

/*****************************************************************************/
/*																		     */
function initBuffers(gl) {
	// Создать буфер для позиций квадрата
	const positionBuffer = gl.createBuffer();

	// Выбрать positionBuffer как точку применения для буфера операций.
	gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);

	const positions = [
		// Front face
		-1.0, -1.0,  1.0,
		1.0, -1.0,  1.0,
		1.0,  1.0,  1.0,
		-1.0,  1.0,  1.0,

		// Back face
		-1.0, -1.0, -1.0,
		-1.0,  1.0, -1.0,
		1.0,  1.0, -1.0,
		1.0, -1.0, -1.0,

		// Top face
		-1.0,  1.0, -1.0,
		-1.0,  1.0,  1.0,
		1.0,  1.0,  1.0,
		1.0,  1.0, -1.0,

		// Bottom face
		-1.0, -1.0, -1.0,
		1.0, -1.0, -1.0,
		1.0, -1.0,  1.0,
		-1.0, -1.0,  1.0,

		// Right face
		1.0, -1.0, -1.0,
		1.0,  1.0, -1.0,
		1.0,  1.0,  1.0,
		1.0, -1.0,  1.0,

		// Left face
		-1.0, -1.0, -1.0,
		-1.0, -1.0,  1.0,
		-1.0,  1.0,  1.0,
		-1.0,  1.0, -1.0,
	];
	// Теперь передать список позиций в WebGL, чтобы построить
	// фигуру. Мы делаем это, создавая Float32Array из
	// JavaScript, затем используйте его для заполнения текущего буфера.
	gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(positions), gl.STATIC_DRAW);


/*MAIN>>>*********************************************************************
	//Базовый массив цветов
	const faceColors = [ //TODO баловаться
		[0.9,  0.9,  0.9,  0.1],    // Front face: white
		[1.0,  0.0,  0.0,  0.8],    // Back face: red
		[0.0,  1.0,  0.0,  0.8],    // Top face: green
		[0.0,  0.0,  1.0,  0.8],    // Bottom face: blue
		[1.0,  1.0,  0.0,  0.8],    // Right face: yellow
		[1.0,  0.0,  1.0,  0.8],    // Left face: purple
	];

	// Массив для конвертации, конвертация в цвет грани
	var colors = [];
	for (var j = 0; j < faceColors.length; ++j) {
		const c = faceColors[j];
		console.log("Текуший цвет: "+ c );
		//т.к. грань куба это квадрат, а цвета задаются вершинам, устанавливаем один цвет на всю грань
		//TODO сдеалать цвет на каждую 3-гнанную пирамиду
		colors = colors.concat(c, c, c, c);
		console.log("Текуший цвет грани: "+ colors);
	}
*<<<MAIN====================================================================*/

/*MOD>>>=====================================================================*/
//Базовый массив цветов
	const faceColors = [
	// Front face
	[1.0,  1.0,  0.0,  0.8], // Yellow	(bottom left)
	[0.0,  0.0,  1.0,  0.8], // Blue	(bottom right)
	[0.0,  1.0,  0.0,  0.8], // Green	(top right)
	[1.0,  0.0,  1.0,  0.8], // Purple	(top left)

	// Back face
	[0.0,  1.0,  0.0,  0.8], // Green	(bottom left)
	[0.0,  0.0,  1.0,  0.8], // Blue	(top left)
	[1.0,  1.0,  0.0,  0.8], // Yellow	(top right)
	[1.0,  0.0,  1.0,  0.8], // Purple	(bottom right)

	// Top face
	[0.0,  0.0,  1.0,  0.8], // Blue	(top left)
	[1.0,  0.0,  1.0,  0.8], // Purple	(bottom left)
	[0.0,  1.0,  0.0,  0.8], // Green	(bottom right)
	[1.0,  1.0,  0.0,  0.8], // Yellow	(top right)

	// Bottom face
	[0.0,  1.0,  0.0,  0.8], // Green	(bottom left)
	[1.0,  0.0,  1.0,  0.8], // Purple	(bottom right)
	[0.0,  0.0,  1.0,  0.8], // Blue	(top right)
	[1.0,  1.0,  0.0,  0.8], // Yellow	(top left)

	// Right face
	[1.0,  0.0,  1.0,  0.8], // Purple	(bottom right)
	[1.0,  1.0,  0.0,  0.8], // Yellow	(top right)
	[0.0,  1.0,  0.0,  0.8], // Green	(top left)
	[0.0,  0.0,  1.0,  0.8], // Blue	(bottom left)

	// Left face
	[0.0,  1.0,  0.0,  0.8], // Green	(bottom left)
	[1.0,  1.0,  0.0,  0.8], // Yellow 	(bottom rignt)
	[1.0,  0.0,  1.0,  0.8], // Purple	(top right)
	[0.0,  0.0,  1.0,  0.8], // Blue	(top left)

	];

	var colors = [];
	var tempColor =[];
	var counter = 4;
	for (var j = 0; j < faceColors.length; ++j) {
		const c = faceColors[j];
		tempColor = tempColor.concat(c);
		counter--;
		if(counter===0){
			colors = colors.concat(tempColor);
			counter = 4;
			tempColor = [];
		}
	}


/*<<<MOD**********************************************************************/

	//И снова конвертируем передаем в буфер
	const colorBuffer = gl.createBuffer();
	gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
	gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);

	const indexBuffer = gl.createBuffer();
	gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, indexBuffer);

	// This array defines each face as two triangles, using the
	// indices into the vertex array to specify each triangle's
	// position.
	const indices = [
		0,  1,  2,      0,  2,  3,    // front
		4,  5,  6,      4,  6,  7,    // back
		8,  9,  10,     8,  10, 11,   // top
		12, 13, 14,     12, 14, 15,   // bottom
		16, 17, 18,     16, 18, 19,   // right
		20, 21, 22,     20, 22, 23,   // left
	];

	// Now send the element array to GL
	gl.bufferData(gl.ELEMENT_ARRAY_BUFFER,
	new Uint16Array(indices), gl.STATIC_DRAW);

	return {
		position: positionBuffer,
		color: colorBuffer,
		indices: indexBuffer,
	};
}

/*****************************************************************************/
/*																			 */
function drawScene(gl, programInfo, buffers, deltaTime) {
	gl.clearColor(0.7, 0.7, 0.7, 0.98);  // Цет основы //TODO баловаться
	gl.clearDepth(1.0);                 // Очистить всё
	gl.enable(gl.DEPTH_TEST);           // Включить проверку глубины
	gl.depthFunc(gl.LEQUAL);            // Near things obscure far things

	// Очистите холст, прежде чем мы начнем рисовать его.
	gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

	// Create a perspective matrix, a special matrix that is
	// used to simulate the distortion of perspective in a camera.
	// Our field of view is 45 degrees, with a width/height
	// ratio that matches the display size of the canvas
	// and we only want to see objects between 0.1 units
	// and 100 units away from the camera.
	const fieldOfView = 45 * Math.PI / 180;   // in radians
	const aspect = gl.canvas.clientWidth / gl.canvas.clientHeight;
	const zNear = 0.1;
	const zFar = 100.0;
	const projectionMatrix = mat4.create();

	// note: glmatrix.js always has the first argument
	// as the destination to receive the result.
	mat4.perspective(projectionMatrix,
	               fieldOfView,
	               aspect,
	               zNear,
	               zFar);

	// Set the drawing position to the "identity" point, which is
	// the center of the scene.
	const modelViewMatrix = mat4.create();

	//Переместить позицию чертежа туда, где мы хотим начать рисовать квадрат.(в 3D)
	mat4.translate(modelViewMatrix,     // матрица назначения
	             modelViewMatrix,     // матрица для перевода
	             [0.0, 0.0, -7.0]);  // amount to translate(x,y,z)//TODO баловаться с Z

	// Для большего смешения при кручении по Z
	mat4.rotate(modelViewMatrix,	// матрица назначения
		modelViewMatrix,			// матрица для вращения
		cubeRotation,				// количество вращаться в радианах
		[0,0,1]);					// оси для поворота вокруг(Y,X,Z) //TODO баловаться с осями вращения
	mat4.rotate(modelViewMatrix,	// матрица назначения
	     modelViewMatrix,			// матрица для вращения
	     cubeRotation *.7,			// количество вращаться в радианах
	     [1,1,1]);					// оси для поворота вокруг(Y,X,Z) //TODO баловаться с осями вращения

	// Скажать WebGL, как вытащить позиции из буфера позиций в атрибут vertexPosition.
	{
	const numComponents = 3;	// брать три занчения за итерацию
	const type = gl.FLOAT;		// указать что данне в буфере, в формате 32bit floats
	const normalize = false;	// отключть нормализацию
	const stride = 0;			// сколько байтов нужно получить от одного набора значений до следующего
	const offset = 0;			// как много байтов в начале буфера

	gl.bindBuffer(gl.ARRAY_BUFFER, buffers.position);
	gl.vertexAttribPointer(
	    programInfo.attribLocations.vertexPosition,
	    numComponents,
	    type,
	    normalize,
	    stride,
	    offset);
	gl.enableVertexAttribArray(
	    programInfo.attribLocations.vertexPosition);
	}

	// Сказать WebGL, как вытащить цвета из цветового буфера в атрибут цвета вершины.
	{
	const numComponents = 4;
	const type = gl.FLOAT;
	const normalize = false;
	const stride = 0;
	const offset = 0;
	gl.bindBuffer(gl.ARRAY_BUFFER, buffers.color);
	gl.vertexAttribPointer(
	    programInfo.attribLocations.vertexColor,
	    numComponents,
	    type,
	    normalize,
	    stride,
	    offset);
	gl.enableVertexAttribArray(
	    programInfo.attribLocations.vertexColor);
	}

	// Сказть WebGL, чтобы использовал нашу программу при рисовании
	gl.useProgram(programInfo.program);

	// Установить шейдерную форму
	gl.uniformMatrix4fv(
		programInfo.uniformLocations.projectionMatrix,
		false,
		projectionMatrix);
	gl.uniformMatrix4fv(
		programInfo.uniformLocations.modelViewMatrix,
		false,
		modelViewMatrix);
	{
		const vertexCount = 36;
		const type = gl.UNSIGNED_SHORT;
		const offset = 0;
		gl.drawElements(gl.TRIANGLES, vertexCount, type, offset);
	}
	// Обновить ротацию для следующей отрисовки
	cubeRotation += deltaTime;
}

/*****************************************************************************/
/*																			 */
function turnOnRotating(){
    if(rotateOn){
		rotateOn = false;
		}else {
		rotateOn = true;
		requestAnimationFrame(render);
	}
}

function positionControl(){
	var currentWidthWindow = window.innerWidth;

	var canvasElement = document.getElementById("glCanvas");
	var buttonElement = document.getElementById("turnOnRotating");

	var a = (currentWidthWindow  - 640)/2;
		if(a<5){a = 5}
	var b = (currentWidthWindow  - 250)/2;

	var valueStyleForCanvas = "left:" + a +"px;";
	var valueStyleForButton = "left:" + b +"px;";

	canvasElement.setAttribute("style",valueStyleForCanvas);
	buttonElement.setAttribute("style",valueStyleForButton);

	document.body.appendChild(canvasElement);
	document.body.appendChild(buttonElement);

}
