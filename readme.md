
# Programlama Dillerinin Prensipleri - 3

SAU 2022-23 Bahar donemi Programlama Dillerinin Prensipleri dersi 3. Odevi

## Istenenler 

  * Program baslangicinda kullanicidan bir girdi alip bu girdiye gore Koloni objeleri olusturmak.

  * Koloni icinde sembol, populasyon, yemek, kazanma , kaybetme sayilari ve turu rasgele belirlenen ve ana bir classdan
  inherit alan Uretim ve Taktik objeleri tutmak.
  * Her tur tum kolonileri savastirip gerekli degerleri guncellemek ve ekrana bastirmak.

  * Son bir koloni kaldiginda kazanani ekrana bastirip programdan cikmak.

  

## Programin isleyisi

* Kullanicidan bir girdi alinir ve bu kod ile bir `Game` objesi olusturulur.
* Girdiye gore `Game` objesi icinde tutulacak olan `Colony` objeleri olusturulur.
* `Game` objesinin `loop` fonksiyonu calistirilarak oyun dongusu baslatilir.
* Birden fazla `Colony` hayatta oldugu surece `Game` objesinin `turn` fonksiyonu calistirilir.
* Her `turn` fonksiyonu cagrildiginda sirasiyla `produce`, `multiply`, `eat`, `fightAll` ve `print` fonksiyonlari cagrilir.
* `produce` fonksiyonunda `Colony` objelerinin sahip olduklari `Production` objelerine gore uretim yapmalari saglanlir.
* `multiply` fonksiyonunda `Colony` objelerinin nufuslari belirlenen oranda arttirilir.
* `eat` fonksiyonunda `Colony` objeleri gereken miktarda yemek tuketir.
* `fightAll` fonksiyonunda `Colony` objeleri birbirleriyle savasir verilen hasarlar sahip olunan `Tactic` turune gore belirlenir, savaslar ve sonuclari eger kullanici basta istediyse ekrana bastirilir.
* `print` fonksiyonunda kolonilerin son durumu ekrana bastirilir.
* Geriye bir adet `Colony` kalana kadar dongu devam eder ve bir tane kalinca kazanan ekrana bastirilir ve programdan cikis yapilir.

## Hazirlayan

- Mustafa Karadeniz G211210066 / 2-B


