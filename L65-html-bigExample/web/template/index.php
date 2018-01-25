<?php defined('_JEXEC') or die;?>
<?php echo '<?'; ?>xml version="1.0" encoding="<?php echo $this->_charset ?>"?>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<jdoc:include type="head" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $this->template ?>/css/emptytemplate.css" type="text/css"/>
</head>

<body>
<div id="wrapper">
	<div id="header"></div>
	<div id= "under_header_line">
		<jdoc:include type="modules" name="top" style="none" />
	</div>
	<div id="leftcolumn">
		<jdoc:include type="modules" name="leftcolumn" style="none" />
	</div>
	<div id="rightcolumn">
		<jdoc:include type="modules" name="rightcolumn" style="none" />
	</div>
	<div id="container">
		<div id=centercolumn>
			<jdoc:include type="component" />
		</div>
	   <div id="in_centercolumn_1"></div>
	   <div id="in_centercolumn_2"></div>
	   <div id="in_centercolumn_3"></div>
	</div>
	
</div>

<div id=prefooter></div>
<div id=footer></div>
</body>
</html>