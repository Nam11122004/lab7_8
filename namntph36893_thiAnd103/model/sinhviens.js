const mongoose = require('mongoose');
const Scheme = mongoose.Schema;

const SinhViens = new Scheme({
    hoten_PH36893: {type: String},
    quequan: {type: String},
    diem: {type: Number},
    hinhanh: {type: String},
})
module.exports = mongoose.model('sinviens',SinhViens)