var express  = require('express');
var router = express.Router();

const SinhViens = require('../model/sinhviens')
const upload = require('../config/comon/upload');
router.post('/add-sinhvien',async (req, res) => {
    try {
        const data = req.body;
   
        const newSinhVien = new SinhViens({
            hoten_PH36893: data.hoten_PH36893,
            quequan: data.quequan,
            diem: data.diem,
      
        });
        const result = await newSinhVien.save();
        if (result) {
            res.json({
                "status": 200,
                "message": "THEM THANH CONG",
                "data": result
            })
        } else {
            res.json({
                "status": 400,
                "message": "LOI, THEM KHONG THANH CONG",
                "data": []
            })
        }
    } catch (error) {
        console.log(error);
    }
})

// lấy dữ liệu
router.get('/get-list-sinhvien', async (req, res) => {
    try {
        const data = await SinhViens.find();
        res.json({
            "status": 200,
            "message": "DANH SACH Student",
            "data": data
        })
    } catch (error) {
        console.log(error);
    }
})

router.delete("/delete-sinhvien-by-id/:id", async (req, res) => {
    try {
        const { id } = req.params;
        const result = await SinhViens.findByIdAndDelete(id);
        if (result) {
            res.json({
                status: 200,
                messenger: "Xoa thanh cong",
                data: result,
            });
        } else {
            res.json({
                status: 400,
                messenger: "Loi. Xoa khong thanh cong",
                data: [],
            });
        }
    } catch (error) {
        console.log(error);
    }
})

router.put("/update-sinhvien-by-id/:id", async (req, res) => {
    try {
        const { id } = req.params;
        const data = req.body;
        const urlImage = `${req.protocol}://${req.get("host")}/uploads/${req.file.filename}`;
        const result = await SinhViens.findByIdAndUpdate(id, {
            hoten_PH36893: data.hoten,
            quequan: data.quequan,
            diem: data.diem,
            hinhanh:urlImage
        });
        if (result) {
            res.json({
                status: 200,
                messenger: "Tìm thấy id và update thành công",
                data: result,
            });
        } else {
            res.json({
                status: 400,
                messenger: "Update thất bại",
                data: null,
            });
        }
    } catch (error) {
        console.log(error);
    }
}) 

 module.exports = router;