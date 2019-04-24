<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
	
	<xsl:template match="/">
		<html>
			<head>
				<title>
				</title>
			</head>
			<body>
				
				<xsl:apply-templates />
			</body>
	    </html>
    </xsl:template>
    
    
    
    <xsl:template match="section">
       <xsl:apply-templates/>
    </xsl:template>
	<xsl:template match="origin">
	<img src="images/6.jpg" style="position:absolute;top:140px;left:50px;height:500px;width:350px;"/>
    
	<img src="images/3.png" style="position:absolute;top:10px;left:260px;height:90px;width:280px;"/>
	<div style="position:absolute; left:455px; top:150px;">
	    
	    <div>
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">	          
	         所在位置：<br/>	         
	         作者：<br/>
	         出品方：<br/>
	         源自：<br/>
	         
	        </div>
	    
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">
	            <xsl:value-of select="anime/anime_content"/><br/>	  
	            <xsl:value-of select="original/author/@author_name"/><br/> 
	            <xsl:value-of select="anime/producer/@producer_name"/><br/> 
	            <xsl:value-of select="original/@form"/><br/> 
	        </div>
	    </div>
	</div>
	</xsl:template>
	
	<xsl:template match="roletable">
	<div style="position:absolute; left:455px; top:280px;">
	    
	    <div>
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">	          
	         角色名称：<br/>	
	         角色变身：<br/> 	                
	         CV：<br/>
	        </div>
	    
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">
	            <xsl:value-of select="role/@role_name"/><br/>	
	            <xsl:value-of select="role"/><br/>
	            <xsl:value-of select="role/@role_cv"/><br/> 
	        </div>
	    </div>
	</div>
	</xsl:template>
	
    <xsl:template match="plot">
	<div style="position:absolute; left:455px; top:390px;">
	    
	    <div>
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">
	         剧情分类：<br/>	          
	         剧情梗概：<br/>	
	         <br/>
	         <br/>
	         <br/>
	         经典台词：<br/>
	          
	         
	        </div>
	    
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">
	            <xsl:value-of select="@plot_classifier"/><br/>	
	            <xsl:value-of select="plot_content"/><br/> 
	            <xsl:value-of select="linestable/lines/linestext"/><br/>
	            
	        </div>
	    </div>
	</div>	
	</xsl:template>	
	
    <xsl:template match="frames">
	<div style="position:absolute; left:455px; top:580px;">
	    
	    <div>
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">
	         场景分类：<br/>	          
	         场景分析：<br/>		         
	        </div>
	    
	        <div style="float:left; text-align:right;front-weight:bold;line-height:2em;">
	            <xsl:value-of select="@frames_classifier"/><br/>	
	            <xsl:value-of select="."/><br/> 
	            
	            
	        </div>
	    </div>
	</div>	
	</xsl:template>	
	
    
</xsl:stylesheet>
