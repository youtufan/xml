xquery version "1.0";
<animes>&#10;
{
  for $object at $x in
  (
  for $anime in distinct-values(doc("chawucidui_9_for40.xml")/root/section/origin/anime/@anime_name)
  order by $anime
  return
  <anime animename="{$anime}">&#10;
    {
      for $authorname in distinct-values(doc("chawucidui_9_for40.xml")/root/section/origin/original/author/@author_name),
      $authorgender in distinct-values(doc("chawucidui_9_for40.xml")/root/section/origin/original/author/@author_gender),
      $authorbirth in distinct-values(doc("chawucidui_9_for40.xml")/root/section/origin/original/author/@author_birth)
      let $sections := doc("chawucidui_9_for40.xml")/root/section
        where
        some $section in $sections 
        satisfies ($section/origin/anime/@anime_name=$anime and $section/origin/original/author/@author_name=$authorname and
        $section/origin/original/author/@author_gender=$authorgender and $section/origin/original/author/@author_birth=$authorbirth )
      return(
        <author name="{$authorname}" gender="{$authorgender}" birth="{$authorbirth}"/>|
          <framestable>&#10;{
          for $frames_classifier in distinct-values(doc("chawucidui_9_for40.xml")/root/section/frames/@frames_classifier)
      let $sections := doc("chawucidui_9_for40.xml")/root/section
        where
        some $section in $sections 
        satisfies ($section/origin/anime/@anime_name=$anime and $section/origin/original/author/@author_name=$authorname and
        $section/origin/original/author/@author_gender=$authorgender and $section/origin/original/author/@author_birth=$authorbirth and $section/frames/@frames_classifier=$frames_classifier)
      return
                  <frames frames_classifier="{$frames_classifier}"> 
                      {
                        for $frames_content in doc("chawucidui_9_for40.xml")/root/section/frames/text()
                        let $fram :=$frames_content/..
                        let $fanime :=$fram/..
                          where
                         ($fanime/origin/anime/@anime_name=$anime and $fram/@frames_classifier=$frames_classifier )
                        return
                        (<frame s_id="{$fanime/@section_id}"/>|<framescontent>&#10;{$frames_content}&#10;</framescontent>)
                      } 
                  </frames>
                  }&#10;
           </framestable>
        )
    }&#10;
  </anime>
  )
  where $x<6
 return 
  $object
}
</animes>    
    
   