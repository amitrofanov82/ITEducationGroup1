<?php defined( '_JEXEC' ) or die( 'Restricted access' ); ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="<?php echo $this->language; ?>" lang="<?php echo $this->language; ?>">
<head>
<jdoc:include type="head" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Документ без названия</title>
<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $this->template;?>/css/system.css" type="text/css" />
<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $this->template;?>/css/general.css" type="text/css" />
<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $this->template; ?>/css/template.css" type="text/css" />

<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $this->template; ?>/css/<?php echo $this->params->get('width'); ?>.css" type="text/css" />
<?php if($this->countModules('left')==0) : ?>
<style type="text/css">
#all{
	margin:0 214px 0 0;}


</style>
<?php endif;?>

<?php if($this->countModules('right')==0) : ?>
<style type="text/css">
#all{
	margin:0 0 0 214px;}


</style>
<?php endif;?>

<?php if(($this->countModules('right')==0) && ($this->countModules('left')==0)) : ?>
<style type="text/css">
#all{
	margin:0;}


</style>
<?php endif;?>

</head>

<body>
<div id="wrapper">
<div id="header">
	<div id="logo">
    	<a href="#"><img src="<?php echo $this->baseurl ?>/templates/<?php echo $this->template; ?>/images/logo.png" width="459" height="77" alt="#"></a>
    </div>
    
    <div id="loz">
    	<?php echo $this->params->get('loz'); ?>
    </div>

</div>


<div id="nav">
	<?php if($this->countModules('top')) : ?>
	<div id="menu">
    	<jdoc:include type="modules" name="top"/>
    </div> 
	<?php endif;?>
</div>

<div id="container">
	<div id="content">
    	<div id="all">
        	<div id="top">
            	<div id="top_back">
                	<div id="top_left">
                    	<div id="top_right">
                        
                        </div>
                    </div>
                </div>
            </div>
            <div id="sodergan">
            	<div id="text">
                	<jdoc:include type="component" />
                </div>
                <?php if($this->countModules('left_l || right_l')) : ?>
                <div id="news">
                	<div class="colon">
                    	<jdoc:include type="modules" name="left_l" style="xhtml" />
                    </div>
                    <div class="colon">
                    	<jdoc:include type="modules" name="right_l" style="xhtml" />
                    </div>
                </div>
                <?php endif;?>
            </div>
            <div id="bot">
            	<div id="bot_back">
                	<div id="bot_left">
                    	<div id="bot_right">
                        
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <?php if($this->countModules('left')) : ?>
	<div id="left_s">
    	<jdoc:include type="modules" name="left" style="mystyle" />
    </div>
    <?php endif;?>
    
    <?php if($this->countModules('right')) : ?>
	<div id="right_s">
    	<jdoc:include type="modules" name="right" style="mystyle" />
    </div>
    <?php endif;?>
</div>
</div>
<div id="footer">
	<span> 
    <?php 
		 echo $this->params->get('god');
		 echo "&copy;";
		$texta= $this->params->get('texta');
		$adresa= $this->params->get('adra');
		echo "<a href='$adresa'> $texta </a>";
		echo $this->params->get('prava');
	
	?> 
    </span>
    
</div>

</body>
</html>
