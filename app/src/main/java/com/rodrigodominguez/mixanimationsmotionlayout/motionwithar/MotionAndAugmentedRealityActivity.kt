package com.rodrigodominguez.mixanimationsmotionlayout.motionwithar

import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Quaternion
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_motion_and_augmented_reality.*


class MotionAndAugmentedRealityActivity : AppCompatActivity() {

      lateinit var arFragment: ArFragment

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_and_augmented_reality)

        arFragment = sceneformFragment as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane, motionEvent: MotionEvent ->
            if (plane.type != Plane.Type.HORIZONTAL_UPWARD_FACING) {
                return@setOnTapArPlaneListener
            }
            val anchor = hitResult.createAnchor()
            placeObject(arFragment, anchor)
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun placeObject(fragment: ArFragment, anchor: Anchor) {
        ViewRenderable.builder()
                .setView(fragment.context, R.layout.activity_food_circle_tabs_ar)
                .build()
                .thenAccept {
                    addControlsToScene(fragment, anchor, it)
                }
                .exceptionally { it ->
                    val builder = AlertDialog.Builder(this)
                    builder.setMessage(it.message).setTitle("Error")
                    val dialog = builder.create()
                    dialog.show()
                    return@exceptionally null
                }
    }

    private fun addControlsToScene(fragment: ArFragment, anchor: Anchor, renderable: Renderable) {
        val anchorNode = AnchorNode(anchor)
        val node = TransformableNode(fragment.transformationSystem)
        node.localScale = Vector3(0.00001f, 0.00001f, 0.00001f)
        node.localRotation = Quaternion.axisAngle(Vector3(-1f, 0f, 0f), 90f)
        node.translationController.isEnabled = false
        node.renderable = renderable
        node.setParent(anchorNode)
        fragment.arSceneView.scene.addChild(anchorNode)
    }
}