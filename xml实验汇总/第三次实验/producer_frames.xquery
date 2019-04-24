xquery version "1.0";
<root>{
let $producer :="Bones"
let $frames :="×ÔÈ»"
return(
<chawucidui_9_for40.xml>&#10;
{
for $x in doc("chawucidui_9_for40.xml")/root/section
where
 ($x/origin/anime/producer/@producer_name=$producer and $x/frames/@frames_classifier=$frames )
return $x
}
&#10;</chawucidui_9_for40.xml>
|<new5.xml>&#10;
{
  for $y in doc("new5.xml")/root/section
  where
  ($y/origin/anime/producer/@producer_name=$producer and $y/frames/@frames_classifier=$frames )
  return
  $y
}
&#10;</new5.xml>
|<combine.xml>&#10;
  {
    for $z in doc("combine.xml")/root/section
    where
    ($z/origin/anime/producer/@producer_name=$producer and $z/frames/@frames_classifier=$frames )
    return
    $z
  }
&#10;</combine.xml>)
}
</root>