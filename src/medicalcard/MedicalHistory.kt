package medicalcard

class MedicalHistory(list: List<MedicalRecord>) {
    private val records: MutableList<MedicalRecord> = list.toMutableList();

    public fun add(record: MedicalRecord) {
        records.add(record);
    }

    public fun size(): Int {
        return records.size
    }
}