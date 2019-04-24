<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
<xsl:template match="root/section">
<link href="img/team.css" rel="stylesheet" type="text/css" title="Style" />
 <div style="float:left;width:100%;padding:5px;margin:5px;background:#cae2ee;">
 <div style="text-align:center;position:center;">
              <div style="padding:5px;margin:40px,25px,30px,25px;">
					<div style="float:left;width:80%;">
                                                <p><font color="black">
                                                    <b>
                                                        <xsl:value-of select="@section_id"/>
                                                        <br/>
                                                    </b>
                                                    <xsl:text>动漫名称： </xsl:text>
                                                    <xsl:value-of select="origin/anime/@anime_name"/><br/><br/>
                                                    <xsl:text>剧集： </xsl:text>
                                                    <xsl:value-of select="origin/anime/anime_content"/><br/><br/>
                                                    <xsl:text>制作公司： </xsl:text>
                                                    <xsl:value-of select="origin/anime/producer/@producer_name"/><br/><br/>
                                                    <xsl:text>国内版权方： </xsl:text>
                                                    <xsl:value-of select="origin/anime/producer"/><br/><br/>
                                                    <xsl:text>作者： </xsl:text>
                                                    <xsl:value-of select="origin/original/author/@author_name"/>
                                                    <xsl:text>(</xsl:text>
                                                    <xsl:value-of select="origin/original/@form"/>
                                                    <xsl:text>)</xsl:text><br/><br/>
                                                    <xsl:text>出场角色： </xsl:text>
                                                    <xsl:for-each select="roletable/role">
                                                    <xsl:value-of select="@role_name"/>&#160;
                                                    </xsl:for-each><br/><br/>
                                                    <xsl:text>剧情： </xsl:text>
                                                    <xsl:text>(</xsl:text>
                                                    <xsl:value-of select="plot/@plot_classifier"/>
                                                    <xsl:text>)</xsl:text>
                                                    <xsl:value-of select="plot/plot_content"/><br/>
                                                    <xsl:text>场景： </xsl:text>
                                                    <xsl:text>(</xsl:text>
                                                    <xsl:value-of select="frames/@frames_classifier"/>
                                                    <xsl:text>)</xsl:text>
                                                    <xsl:value-of select="frames"/></font>
                                                </p>
                                                </div>
                    <div style="float:right;width:20%;">
                         <a class="hdimg img" ><img src="img/VE.jpg" width="100%"/>
                         </a>
                    </div>
                </div>	
 </div>
 <div style="float:left;width:100%;padding:5px;margin:5px;background:#cae2ee;">
            <div style="float:left;width:33%">
                <a class="hdimg img" ><img src="img/cj01.jpg" width="100%"/>
                </a>
            </div>
            <div style="float:left;width:33%">
                <a class="hdimg img" ><img src="img/cj02.jpg" width="100%"/>
                </a>
            </div>
            <div style="float:left;width:33%">
                <a class="hdimg img" ><img src="img/cj03.jpg" width="100%"/>
                </a>
            </div>
            </div>

<xsl:for-each select="plot/linestable/lines">
    <div style="float:left;width:100%;padding:5px;margin:5px;background:#cae2ee;">
       <xsl:if test="@lines_id[.='01']">
       <div style="float:right;width:65%;"><font color="black"><br/>
            <xsl:value-of select="speaker"/>
            <xsl:text>： </xsl:text><br/>
            <xsl:value-of select="linestext"/><br/></font>
        </div>
        <div style="float:right;width:25%;">
            <div class="m-hdimg">
                <a class="hdimg img">
                <img src="img/lines1.jpg"/>
                </a>
            </div>
        </div>
        </xsl:if>
        
        <xsl:if test="@lines_id[.='02']">
         <div style="float:right;width:65%;"><font color="black"><br/>
            <xsl:value-of select="speaker"/>
            <xsl:text>： </xsl:text><br/>
            <xsl:value-of select="linestext"/><br/></font>
        </div>
        <div style="float:right;width:25%;">
            <div class="m-hdimg">
                <a class="hdimg img">
                <img src="img/lines2.jpg"/>
                </a>
            </div>
        </div>
        </xsl:if>
     </div>
</xsl:for-each>

 </div>
</xsl:template>
</xsl:stylesheet>
