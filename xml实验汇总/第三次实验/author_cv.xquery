xquery version "1.0";
<root>{
let $authorname :="Ïþ¼ÑÄÎ"
let $cv :="ÀË´¨´ó¸¨"
return(
<chawucidui_9_for40.xml>&#10;
{
for $x in doc("chawucidui_9_for40.xml")/root/section
where
 ($x/origin/original/author/@author_name=$authorname and $x/roletable/role/@role_cv=$cv )
return $x
}
&#10;</chawucidui_9_for40.xml>
|<new5.xml>&#10;
{
  for $y in doc("new5.xml")/root/section
  where
  ($y/origin/original/author/@author_name=$authorname and $y/roletable/role/@role_cv=$cv )
  return
  $y
}
&#10;</new5.xml>
|<combine.xml>&#10;
  {
    for $z in doc("combine.xml")/root/section
    where
    ($z/origin/original/author/@author_name=$authorname and $z/roletable/role/@role_cv=$cv )
    return
    $z
  }
&#10;</combine.xml>
)
}
</root>