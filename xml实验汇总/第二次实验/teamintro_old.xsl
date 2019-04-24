<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
 <xsl:template match="/">
 <link href="img/team.css" rel="stylesheet" type="text/css" title="Style" />
 <div style="float:left;width:98%;padding:5px;margin:5px;background:#f3f3df;">
            <div style="text-align:center;position:center;">
              <div class="m-hdimg">
                <a class="hdimg img" >
                  <img src="img/icon.jpg" width="128"/>
                 </a>
                 <h2><font color="black"><b>
                 <xsl:value-of select="team/imfomation/teamname"/></b></font>
                 </h2>
                 <font color="black">
                 <xsl:value-of select="team/imfomation/iconintro"/><br/>
                 <xsl:value-of select="team/imfomation/iconintro_add"/><br/>
                 <xsl:value-of select="team/imfomation/introtext"/><br/>
                 </font>
              </div>
            </div>
 </div>
 <xsl:for-each select="team/memeber">
  <xsl:if test="basic/name[.='Zhang Sunlanxin']">
   <div style="float:left;width:32%;padding:5px;margin:5px;background:#a0d2fd;">
     <div style="text-align:center;position:center;">
              <div class="m-hdimg">
                <a class="hdimg img" >
                  <img src="img/zhangicon.jpg" style="width: 128px; height: 128px;"/>
                 </a>
                 <br/>
                 <font color="black"><b>
                 <xsl:value-of select="basic/name"/></b>
                 <xsl:if test="@ifleader[.='yes']"><xsl:text>(leader)</xsl:text></xsl:if><br/>
                 <xsl:text>StudentID: </xsl:text>
                 <xsl:value-of select="education/studentnumber/@sID"/><br/>
                 <xsl:text>QQ: </xsl:text>
                 <xsl:value-of select="basic/QQnumb"/><br/>
               </font>
          </div>
       </div>
   </div>
   </xsl:if>
   <xsl:if test="basic/name[.='Wang Mengfan']">
   <div style="float:left;width:32%;padding:5px;margin:5px;background:#ffbdd3;">
     <div style="text-align:center;position:center;">
              <div class="m-hdimg">
                <a class="hdimg img" >
                  <img src="img/wangicon.jpg" width="128"/>
                 </a>
                 <br/>
                 <font color="black"><b>
                 <xsl:value-of select="basic/name"/></b>
                 <xsl:if test="@ifleader[.='yes']"><xsl:text>(leader)</xsl:text></xsl:if><br/>
                 <xsl:text>StudentID: </xsl:text>
                 <xsl:value-of select="education/studentnumber/@sID"/><br/>
                 <xsl:text>QQ: </xsl:text>
                 <xsl:value-of select="basic/QQnumb"/><br/>
               </font>
          </div>
       </div>
   </div>
   </xsl:if>
   <xsl:if test="basic/name[.='Zou Shiyi']">
    <div style="float:left;width:32%;padding:5px;margin:5px;background:#a5fbb3;">
     <div style="text-align:center;position:center;">
              <div class="m-hdimg">
                <a class="hdimg img" >
                  <img src="img/zouicon.jpg" width="128"/>
                 </a>
                 <br/>
                 <font color="black"><b>
                 <xsl:value-of select="basic/name"/></b>
                 <xsl:if test="@ifleader[.='yes']"><xsl:text>(leader)</xsl:text></xsl:if><br/>
                 <xsl:text>StudentID: </xsl:text>
                 <xsl:value-of select="education/studentnumber/@sID"/><br/>
                 <xsl:text>QQ: </xsl:text>
                 <xsl:value-of select="basic/QQnumb"/><br/>
               </font>
          </div>
       </div>
   </div>
  </xsl:if>
 </xsl:for-each>
 </xsl:template>
</xsl:stylesheet>
