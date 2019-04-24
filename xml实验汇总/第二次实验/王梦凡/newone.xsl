<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	
	<xsl:template match="/">
		<html>
			<head>
				<title><xsl:value-of select="root/section/origin/anime/@anime_name"/>
				</title>
			</head>
			<body>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	
<!--<xsl:value-of select="anime/@anime_name"/>-->
	
	<xsl:template match="section">
		<xsl:apply-templates />
	</xsl:template>
	
	<xsl:template match="origin">
        <img src="images/title.png" style="position:absolute;left:420px;height:130px;width:1000px;"/>
		<img src="images/yx.jpg" style="position:absolute;top:140px;left:30px;height:300px;width:400px;"/>
		<img src="images/yy.jpg"  style="float:right;margin-top:138px;margin-right:30px;height:300px;width:350px;"/>
		<div style="position:absolute;left:600px;top:150px;">
			<h2 style="text-align:center;margin-left:35px">
				��Դ����
			</h2>
			<div>
				<div style="float:left;text-align:right;font-weight:blod;line-height:2em;">
                ������<br/>
                ��Ʒ��(����)��<br/>
                ��Ʒ��(�ڵ�)��<br/>
                ���ԣ�<br/>
                ���֣�<br/>
                �Ա�<br/>
                �������ڣ�<br/>
				</div>
				<div style="float:left;text-align:left;margin-left:20px;line-height:2em;">
					<xsl:value-of select="anime/anime_content"/>
					<br/>
					<xsl:value-of select="anime/producer/@producer_name"/>
					<br/>
					<xsl:value-of select="anime/producer"/>
					<br/>
					<xsl:value-of select="original/@form"/>
					<br/>
					<xsl:value-of select="original/author/@author_name"/>
					<br/>
					<xsl:value-of select="original/author/@author_gender"/>
					<br/>
					<xsl:value-of select="original/author/@author_birth"/>
					<br/>
				</div>
			</div>
		</div>
		
	</xsl:template>
	
	<xsl:template match="roletable">
		<div style="position:absolute;top:500px;width:100%">
			<h2 style="text-align:center;">
				��ɫ��
			</h2>
			<div>
				<div style="float:left;text-align:right;font-weight:blod;line-height:2em;margin-left:20px;">
                ��ɫ���֣�<br/>
                �Ա�<br/>
                ���䣺<br/>
                CV��<br/>
                ��ɫ���ܣ�<br/>
				</div>
				<div style="float:left;text-align:left;margin-left:90px;margin-top:-160px;line-height:2em;">
					<xsl:value-of select="role/@role_name"/>
					<br/>
					<xsl:value-of select="role/@role_gender"/>
					<br/>
					<xsl:value-of select="role/@role_age"/>
					<br/>
					<xsl:value-of select="role/@role_cv"/>
					<br/>
					<xsl:value-of select="role/."/>
					<br/>
					
				</div>
			</div>
		</div>
	</xsl:template>
	
	<xsl:template match="plot">
		<div style="position:absolute;top:770px;width:100%">
			<h2 style="text-align:center;">
				����
			</h2>
			<div>
				<div style="float:left;text-align:right;font-weight:blod;line-height:2em;margin-left:20px;">
                ���ࣺ<br/>
                �������ݣ�<br/>
				</div>
				<div style="float:left;text-align:left;margin-left:20px;line-height:2em;">
					<xsl:value-of select="@plot_classifier"/>
					<br/>
					<xsl:value-of select="plot_content"/>
					<br/>
					
				</div>
			</div>
		</div>
		<xsl:apply-templates select="linestable"/>
	</xsl:template>
	
	<xsl:template match="linestable">
	    <div style="position:absolute;width:540px;margin-top:910px;">
	        <table border="1" style="margin-left:20px">
                <tr  style="height:50px;">
                    <th style="width:100px;">̨�ʱ��</th>
                    <th style="width:100px;">����</th>
                    <th style="width:100px;">̨�ʹؼ���</th>
                    <th style="width:1300px;">̨������</th>
                </tr>
                <xsl:for-each select="lines">
                <tr>
                    <td><xsl:value-of select="@lines_id"/></td>
                    <td><xsl:value-of select="speaker"/></td>
                    <td><xsl:value-of select="linestext/@keyword"/></td>
                    <td><xsl:value-of select="linestext"/></td>
                </tr>
                </xsl:for-each>
            </table>
            <br/>
	    </div>
	</xsl:template>
	
	<xsl:template match="frames">
		<div style="position:absolute;margin-top:1120px;width:100%">
			<h2 style="text-align:center;">
				����
			</h2>
			<div>
				<div style="float:left;font-weight:blod;line-height:2em;margin-left:20px;">
                  �������<xsl:value-of select="@frames_classifier"/><br/>
                  ����������<xsl:value-of select="."/><br/>
				</div>
				
			</div>
		</div>
		
	</xsl:template>
	
</xsl:stylesheet>
