package countries

fun main() {
    println(vocalsAndConsonants())
    println(anagrams().mapValues { it.value.size }.values.sortedDescending())
    println(anagrams().filter { it.value.size == 5 })
    println(notInWord("henrik torland klev"))
}

fun vocalsAndConsonants(): List<String> = countries.split("\n").filter { country ->
    val vocalCount = country.lowercase().count { it in consonants }
    val consonantCount = country.lowercase().count { it !in consonants }
    vocalCount == consonantCount * 2
}

fun anagrams(): Map<String, List<String>> = countries.split("\n").associateWith { country ->
    countries
        .split("\n")
        .filterNot { it == country }
        .filter { country.lowercase().toCharArray().toList().containsAll(it.lowercase().toCharArray().toList()) }
}.filterNot { it.value.isEmpty() }


fun notInWord(word: String): List<String> = countries.split("\n").filterNot { it.lowercase().any { it in word.lowercase() } }

val consonants = setOf('a', 'e', 'i', 'o', 'u', 'y', 'æ', 'ø', 'å')

const val countries = """Afghanistan
Albania
Algerie
Andorra
Angola
Antigua og Barbuda
Argentina
Armenia
Aserbajdsjan
Australia
Bahamas
Bahrain
Bangladesh
Barbados
Belarus 
Hviterussland
Belgia
Belize
Benin
Bhutan
Bolivia
Bosnia-Hercegovina
Botswana
Brasil
Brunei
Bulgaria
Burkina Faso
Burundi
Canada
Chile
Colombia
Cookøyene
Costa Rica
Cuba
Danmark
De forente arabiske emirater
Den dominikanske republikk
Den sentralafrikanske republikk
Djibouti
Dominica
Ecuador
Egypt
Ekvatorial-Guinea
El Salvador
Elfenbenskysten
Eritrea
Estland
Eswatini
Etiopia
Fiji
Filippinene
Finland
Frankrike
Gabon
Gambia
Georgia
Ghana
Grenada
Guatemala
Guinea
Guinea-Bissau
Guyana
Haiti
Hellas
Honduras
India
Indonesia
Irak
Iran
Irland
Island
Israel
Italia
Jamaica
Japan
Jemen
Jordan
Kambodsja
Kamerun
Kapp Verde
Kasakhstan
Kenya
Kina
Kirgisistan
Kiribati
Komorene
Den demokratiske republikken Kongo
Republikken Kongo
Kosovo
Kroatia
Kuwait
Kypros
Laos
Latvia
Lesotho
Libanon
Liberia
Libya
Liechtenstein
Litauen
Luxembourg
Madagaskar
Malawi
Malaysia
Maldivene
Mali
Malta
Marokko
Marshalløyene
Mauritania
Mauritius
Mexico
Mikronesia
Moldova
Monaco
Mongolia
Montenegro
Mosambik
Myanmar (Burma)
Namibia
Nauru
Nederland
Nepal
New Zealand
Nicaragua
Niger
Nigeria
Niue
Nord-Korea
Nord-Makedonia
Norge
Oman
Pakistan
Palau
Palestina
Panama
Papua Ny-Guinea
Paraguay
Peru
Polen
Portugal
Qatar
Romania
Russland
Rwanda
Saint Kitts og Nevis
Saint Lucia
Saint Vincent og Grenadinene
Salomonøyene
Samoa
San Marino
Saudi-Arabia
Senegal
Serbia
Seychellene
Sierra Leone
Singapore
Slovakia
Slovenia
Somalia
Spania
Sri Lanka
Storbritannia
Sudan
Surinam
Sveits
Sverige
Syria
São Tomé og Príncipe
Sør-Afrika
Sør-Korea
Sør-Sudan
Tadsjikistan
Taiwan
Tanzania
Thailand
Togo
Tonga
Trinidad og Tobago
Tsjad
Tsjekkia
Tunisia
Turkmenistan
Tuvalu
Tyrkia
Tyskland
Uganda
Ukraina
Ungarn
Uruguay
USA
Usbekistan
Vanuatu
Vatikanstaten
Venezuela
Vest-Sahara
Vietnam
Zambia
Zimbabwe
Øst-Timor
Østerrike"""