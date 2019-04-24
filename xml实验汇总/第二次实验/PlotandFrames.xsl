<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
<xsl:template match="/">
  <html>
    <link href="img/stlsheet.css" rel="stylesheet" type="text/css" title="Style" />
    <body class="p-detailpage">
        <div class="g-mn">
            <div class="g-mnc box">	
				<div class="m-postdtl">
					<div class="m-post  m-post-txt  ">
						<div class="postinner">
							<div class="ct">
								<div class="ctc box">
									<h2 class="ttl">剧情和场景描述一览</h2>			
										<div class="txtcont">										
											<xsl:for-each select="root/section">
                                                <p>
                                                    <b>
                                                        <xsl:value-of select="@section_id"/>
                                                        <br/>
                                                    </b>
                                                    <xsl:text>剧情： </xsl:text>
                                                    <xsl:value-of select="plot/plot_content"/><br/>
                                                    <xsl:text>场景： </xsl:text>
                                                    <xsl:value-of select="frames"/>
                                                </p>	
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
