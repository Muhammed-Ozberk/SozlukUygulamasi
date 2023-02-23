package com.example.sozlukuygulamasi

class Kelimelerdao {
    fun tumKelimeler(vt: VeritabaniYardimcisi): ArrayList<Kelimeler> {
        val kelimelerArrayList = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler", null)
        while (c.moveToNext()) {
            val k = Kelimeler(
                c.getInt(c.getColumnIndexOrThrow("kelime_id"))
                , c.getString(c.getColumnIndexOrThrow("ingilizce"))
                , c.getString(c.getColumnIndexOrThrow("turkce"))
            )
            kelimelerArrayList.add(k)
        }
        return kelimelerArrayList
    }

    fun kelimeAra(vt: VeritabaniYardimcisi, aramaKelime: String): ArrayList<Kelimeler> {
        val kelimelerArrayList = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery(
            "SELECT * FROM kelimeler WHERE ingilizce like '%$aramaKelime%'",
            null
        )
        while (c.moveToNext()) {
            val k = Kelimeler(
                c.getInt(c.getColumnIndexOrThrow("kelime_id"))
                , c.getString(c.getColumnIndexOrThrow("ingilizce"))
                , c.getString(c.getColumnIndexOrThrow("turkce"))
            )
            kelimelerArrayList.add(k)
        }
        return kelimelerArrayList
    }
}