xquery version "1.0";
<countries>&#10;
{
  for $country in distinct-values(doc("chawucidui_9_for40.xml")/root/section/origin/@country)
  return
  <country name="{$country}">&#10;
    {
      for $anime in distinct-values(doc("chawucidui_9_for40.xml")/root/section/origin/anime/@anime_name)
      let $sections := doc("chawucidui_9_for40.xml")/root/section
        where
        some $section in $sections 
        satisfies ($section/origin/@country=$country  and $section/origin/anime/@anime_name=$anime)
      return
        <anime name="{$anime}">&#10;
          {
            for $animecontent in distinct-values(doc("chawucidui_9_for40.xml")/root/section/origin/anime/anime_content)
            let $sections := doc("chawucidui_9_for40.xml")/root/section
              where
              some $section in $sections 
              satisfies ($section/origin/anime/@anime_name=$anime and $section/origin/anime/anime_content=$animecontent)
            return
              <number content="{$animecontent}">&#10;
                { 
                  for $section_id in doc("chawucidui_9_for40.xml")/root/section/@section_id
                  let $sections := doc("chawucidui_9_for40.xml")/root/section
                    where
                    some $section in $sections 
                    satisfies ($section/origin/anime/@anime_name=$anime and $section/origin/anime/anime_content=$animecontent and $section/@section_id=$section_id)
                  return
                    <section setion_id="{$section_id}">&#10;
                      {
                        for $plot_classifier in distinct-values(doc("chawucidui_9_for40.xml")/root/section/plot/@plot_classifier),$frames_classifier in distinct-values(doc("chawucidui_9_for40.xml")/root/section/frames/@frames_classifier)
                        let $sections := doc("chawucidui_9_for40.xml")/root/section
                          where
                          some $section in $sections 
                          satisfies ($section/origin/anime/@anime_name=$anime and $section/origin/anime/anime_content= $animecontent and $section/plot/@plot_classifier=$plot_classifier  and $section/frames/@frames_classifier=$frames_classifier and $section/@section_id=$section_id)
                        return(
                        <plot plot_classifier="{$plot_classifier}">
                      {
                        for $plot_content in doc("chawucidui_9_for40.xml")/root/section/plot/plot_content
                        let $sections := doc("chawucidui_9_for40.xml")/root/section
                          where
                          some $section in $sections 
                          satisfies ($section/origin/anime/@anime_name=$anime and $section/origin/anime/anime_content=  $animecontent and $section/plot/@plot_classifier=$plot_classifier  and $section/frames/@frames_classifier=$frames_classifier and $section/@section_id=$section_id and $section/plot/plot_content=$plot_content)
                        return
                        $plot_content/text()
                      }
                     </plot>
                     |<frames frames_classifier="{$frames_classifier}">
                      {
                        for $frames_content in doc("chawucidui_9_for40.xml")/root/section/frames
                        let $sections := doc("chawucidui_9_for40.xml")/root/section
                          where
                          some $section in $sections 
                          satisfies ($section/origin/anime/@anime_name=$anime and $section/origin/anime/anime_content=  $animecontent and $section/plot/@plot_classifier=$plot_classifier  and $section/frames/@frames_classifier=$frames_classifier and $section/@section_id=$section_id and $section/frames=$frames_content)
                        return
                        $frames_content/text()
                      }
                     </frames>
                     )
                      } &#10;
                   </section>
                }&#10;
             </number>
          }&#10;
       </anime>
    } &#10;
</country>
}&#10;
</countries>