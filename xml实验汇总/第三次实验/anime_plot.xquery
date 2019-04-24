xquery version "1.0";
<root>{
let $anime :="东京食尸鬼"
let $plot :="战斗"
return 
(
<chawucidui_9_for40.xml>&#10;
{
for $x in doc("chawucidui_9_for40.xml")/root/section
where
 ($x/origin/anime/@anime_name=$anime and $x/plot/@plot_classifier=$plot )
return 
$x
}
&#10;</chawucidui_9_for40.xml>
|<new5.xml>&#10;
{
  for $y in doc("new5.xml")/root/section
  where
  ($y /origin/anime/@anime_name=$anime and $y/plot/@plot_classifier=$plot )
  return
  $y
}
&#10;</new5.xml>
|<combine.xml>&#10;
  {
    for $z in doc("combine.xml")/root/section
    where
    ($z/origin/anime/@anime_name=$anime and $z/plot/@plot_classifier=$plot )
    return
    $z
  }
&#10;</combine.xml>
)
}
</root>