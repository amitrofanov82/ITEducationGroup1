//
//  Класс квадрата
//
function Square(row, col, course)
{
	// координаты строки и столбца
	this.body = [row, col];
	
	// направление движения
	this.course = course;
	
	var that = this;
	
	this.create = function()
	{
		m1.setCell(that.body[0], that.body[1], true);
	}
	
	this.move = function()
	{	
		var last_body = that.body;
		switch(that.course)
		{		
			case 'right':
			that.body[1]++;
			break;	
			case 'left':
			break;
			case 'down':
			break;
			case 'up':
			break;
		}
		
		m1.setCell(last_body[0], last_body[1], false);
		m1.setCell(that.body[0], that.body[1], true);	
	}	
}