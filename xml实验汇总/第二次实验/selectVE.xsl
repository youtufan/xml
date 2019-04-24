<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
<xsl:template match="/">
  <html>
    <link href="img/stlsheet.css" rel="stylesheet" type="text/css" title="Style" />
    <body class="p-detailpage">
        <div class="g-sd">
                <div class="g-sdc box">
                    <div class="m-hdimg">
                        <a class="hdimg img" >
                            <img src="img/VE.jpg" width="300"/>
                        </a>
                    </div>
                </div>
			</div>
        <div class="g-mn">
            <div class="g-mnc box">	
				<div class="m-postdtl">
					<div class="m-post  m-post-txt  ">
						<div class="postinner">
							<div class="ct">
								<div class="ctc box">
										<div class="txtcont">		
										  <h2 class="ttl">紫罗兰永恒花园</h2>								
											<xsl:for-each select="root/section">	
											<xsl:if test="origin/anime/@anime_name[.='紫罗兰永恒花园']">
											  <div style="padding:5px;margin:20px,5px,80px,5px;">
											   <div style="float:left;width:900px;">
                                                <p>
                                                    <b>
                                                        <xsl:value-of select="@section_id"/>
                                                        <br/>
                                                    </b>
                                                    <xsl:text>剧集： </xsl:text>
                                                    <xsl:value-of select="origin/anime/anime_content"/><br/>
                                                    <xsl:text>制作公司： </xsl:text>
                                                    <xsl:value-of select="origin/anime/producer/@producer_name"/><br/>
                                                    <xsl:text>国内版权方： </xsl:text>
                                                    <xsl:value-of select="origin/anime/producer"/><br/>
                                                    <xsl:text>作者： </xsl:text>
                                                    <xsl:value-of select="origin/original/author/@author_name"/>
                                                    <xsl:text>(</xsl:text>
                                                    <xsl:value-of select="origin/original/@form"/>
                                                    <xsl:text>)</xsl:text><br/>
                                                    <xsl:text>出场角色： </xsl:text>
                                                    <xsl:for-each select="roletable/role">
                                                    <xsl:value-of select="@role_name"/>&#160;
                                                    </xsl:for-each><br/>
                                                    <xsl:text>剧情： </xsl:text>
                                                    <xsl:text>(</xsl:text>
                                                    <xsl:value-of select="plot/@plot_classifier"/>
                                                    <xsl:text>)</xsl:text>
                                                    <xsl:value-of select="plot/plot_content"/><br/>
                                                    <xsl:text>名台词： </xsl:text><br/>
                                                    <xsl:for-each select="plot/linestable/lines">
                                                    <xsl:value-of select="@lines_id"/>&#160;
                                                    <xsl:value-of select="speaker"/><xsl:text>： </xsl:text>
                                                    <xsl:value-of select="linestext"/><br/>
                                                    </xsl:for-each>
                                                    <xsl:text>场景： </xsl:text>
                                                    <xsl:text>(</xsl:text>
                                                    <xsl:value-of select="frames/@frames_classifier"/>
                                                    <xsl:text>)</xsl:text>
                                                    <xsl:value-of select="frames"/>
                                                </p>
                                                </div>
                                              </div>
                                             </xsl:if>	
                                            </xsl:for-each>				
										</div>
								</div>
							</div>
							<div class="info box">
								<a class="date">2019-03-28</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

  </body>
  </html>
</xsl:template>
</xsl:stylesheet>
