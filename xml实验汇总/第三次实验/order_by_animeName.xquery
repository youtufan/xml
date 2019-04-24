xquery version "1.0";
<root>{
for $x in doc("chawucidui_9_for40.xml")/root/section
order by $x/origin/anime/@anime_name
return $x
}
</root>