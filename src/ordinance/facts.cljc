(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Wellington -- the
  FORTY-FOURTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok, -are-abu-dhabi,
  -vnm-hanoi, -idn-jakarta, -phl-manila, -egy-cairo, -tur-ankara,
  -nga-abuja, -sau-riyadh, -mys-kuala-lumpur, -aut-vienna, -che-bern,
  -irl-dublin for the first forty-three) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). New Zealand's first
  entry across any of the 3 axes.

  Singapore was considered first for this tick's municipality target
  but abandoned: as a city-state, Singapore has no distinct municipal
  government layer separate from its national government (unlike
  every other municipality in this catalog), making it a poor
  structural fit for this axis.

  Wellington is New Zealand's stable capital, with no ongoing
  ambiguity.

  wellington.govt.nz's own history page returned HTTP 403, so this
  catalog's entries instead cite en.wikipedia.org, directly
  WebFetched and read (not merely WebSearch-cited).

  Wellington incorporated as a city on 16 September 1870 -- directly
  confirmed via en.wikipedia.org's Wellington City Council article,
  which states verbatim: 'Wellington's city status was formally
  recognized through the Municipal Corporations Act 1886, which
  \"retroactively recognising it to have been such since 16 September
  1870.\"' (the original 1870 incorporation predates the 1886
  confirming Act; the first mayor's name incidentally encountered but
  never persisted).

  The current Wellington City Council was established via the 1989
  New Zealand local government reforms -- directly confirmed via the
  same Wikipedia article, which states verbatim: 'It was established
  in 1989, replacing a borough council of the same name that had
  existed since 1870.' (used 1 November 1989 as :enacted-date, per
  the article's own infobox).

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"wellington"
   [{:ordinance/id "wellington.incorporation-1870-09-16"
     :ordinance/title "Wellington incorporated as a city (Municipal Corporations Act 1886 retroactively confirms this date)"
     :ordinance/municipality "wellington"
     :ordinance/country "NZL"
     :ordinance/kind :local-act
     :ordinance/number "confirmed by Municipal Corporations Act 1886"
     :ordinance/url "https://en.wikipedia.org/wiki/Wellington_City_Council"
     :ordinance/url-provenance :wikipedia-corroborated
     :ordinance/enacted-date "1870-09-16"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}
    {:ordinance/id "wellington.1989-local-government-reforms"
     :ordinance/title "Wellington City Council established via the 1989 New Zealand local government reforms"
     :ordinance/municipality "wellington"
     :ordinance/country "NZL"
     :ordinance/kind :local-act
     :ordinance/number "1989"
     :ordinance/url "https://en.wikipedia.org/wiki/Wellington_City_Council"
     :ordinance/url-provenance :wikipedia-corroborated
     :ordinance/enacted-date "1989-11-01"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-nzl-wellington Wave 0 (ADR-2607141700): "
                 (count (get catalog "wellington")) " Wellington entries seeded "
                 "with Wikipedia citations (wellington.govt.nz 403'd). "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
