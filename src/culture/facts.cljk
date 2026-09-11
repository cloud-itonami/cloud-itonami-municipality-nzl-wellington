(ns culture.facts
  "Regional-culture catalog for Wellington -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked onto
  this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"wellington"
   [{:culture/id "wellington.dish.pavlova"
     :culture/name "Pavlova"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :dish
     :culture/summary "Meringue-based dessert originating in either Australia or New Zealand in the early 20th century; both nations claim it as a national symbol."
     :culture/url "https://en.wikipedia.org/wiki/Pavlova_(dessert)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.dish.hangi"
     :culture/name "Hāngī"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :dish
     :culture/summary "Traditional New Zealand Māori method of cooking food with heated rocks buried in a pit oven, still used for special occasions and communal gatherings."
     :culture/url "https://en.wikipedia.org/wiki/H%C4%81ng%C4%AB"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.dish.rewena-bread"
     :culture/name "Rēwena bread"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :dish
     :culture/summary "Traditional Māori sourdough bread from New Zealand, made with a fermented potato starter."
     :culture/url "https://en.wikipedia.org/wiki/R%C4%93wena_bread"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.beverage.flat-white"
     :culture/name "Flat white"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :beverage
     :culture/summary "Espresso-and-steamed-milk coffee whose invention is claimed by café owners in both New Zealand and Australia, with competing claims from Wellington and Auckland alongside Sydney."
     :culture/url "https://en.wikipedia.org/wiki/Flat_white"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.product.manuka-honey"
     :culture/name "Mānuka honey"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :product
     :culture/summary "Monofloral honey produced from the nectar of the mānuka tree (Leptospermum scoparium), indigenous to New Zealand and parts of coastal Australia."
     :culture/url "https://en.wikipedia.org/wiki/M%C4%81nuka_honey"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.festival.matariki"
     :culture/name "Matariki"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :festival
     :culture/summary "Celebration of the first rising of the Pleiades star cluster marking the Māori new year, an official public holiday in New Zealand since 24 June 2022."
     :culture/url "https://en.wikipedia.org/wiki/Matariki"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.festival.world-of-wearableart"
     :culture/name "World of WearableArt"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :festival
     :culture/summary "Annual wearable-art show held in Wellington, attended by around 60,000 people at the TSB Arena on the city's waterfront."
     :culture/url "https://en.wikipedia.org/wiki/World_of_WearableArt"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.heritage.te-papa"
     :culture/name "Museum of New Zealand Te Papa Tongarewa"
     :culture/name-local "Te Papa Tongarewa"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :heritage
     :culture/summary "New Zealand's national museum, located in Wellington; the Māori name Te Papa Tongarewa translates to container of treasures."
     :culture/url "https://en.wikipedia.org/wiki/Museum_of_New_Zealand_Te_Papa_Tongarewa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "wellington.heritage.wellington-cable-car"
     :culture/name "Wellington Cable Car"
     :culture/municipality "wellington"
     :culture/country "NZL"
     :culture/kind :heritage
     :culture/summary "Funicular railway opened in 1902, connecting Lambton Quay in central Wellington to the suburb of Kelburn, and a major tourist attraction."
     :culture/url "https://en.wikipedia.org/wiki/Wellington_Cable_Car"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-nzl-wellington culture catalog "
                 "(ADR-2607171400): " (count (get catalog "wellington"))
                 " Wellington entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
