<?php defined('_JEXEC') or die;?>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<jdoc:include type="head" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Аэроклуб "Пепелац"</title>
	<link rel="stylesheet" type="text/css" href="<?php echo $this->baseurl ?>/templates/system/css/system.css" />
	<link rel="stylesheet" type="text/css" href="<?php echo $this->baseurl ?>/templates/<?php echo $this->template ?>/css/mainpx.css" />
	<?php if($this->countModules('rightcolumn')==0) : ?>
		<style type="text/css">
			#centercolumnwrapper{
			margin:0 0 0 224px;
			}
		</style>
	<?php endif;?>

</head>

<body>
	<div id="header">			  
		<div id="header_right"><jdoc:include type="modules" name="righthead" style="xhtml" /></div>
	</div>
	<div id= "under_header_line"><jdoc:include type="modules" name="underheader" style="xhtml" /></div>
	
	<div id="contentwrapper">
		<div id="columnwrapper">         
			<div id="centercolumnwrapper">
				<div id="centercolumncontent">
					<div id="maincontent"><jdoc:include type="component" /></div>
					<div id="leftbottomcolumn"><jdoc:include type="modules" name="in_centercolumn_1" style="xhtml" /></div>
					<div id="rightbottomcolumn"><jdoc:include type="modules" name="in_centercolumn_2" style="xhtml" /></div>
				</div>
			</div>
		</div>
		<div id="leftcolumn"><jdoc:include type="modules" name="leftcolumn" style="xhtml" /></div>
		<div id="rightcolumn"><jdoc:include type="modules" name="rightcolumn" style="xhtml" /></div>
	</div>
	
	<div id="prefooter"><jdoc:include type="modules" name="prefoot" style="xhtml" /></div>
	<div id="prefooterline"></div>
	<div id="footer"></div>
</body>
</html>