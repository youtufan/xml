xquery version "1.0";
let  $newDoc :=  doc("new5.xml")/root/section
return
<root>
{ $newDoc}
{
for $plot at $x in doc("chawucidui_9_for35.xml")/root/section/plot[@plot_classifier="Õ½¶·"]
 where $x<6
 return 
 $plot/..
}
</root>